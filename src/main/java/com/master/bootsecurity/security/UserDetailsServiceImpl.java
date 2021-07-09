package com.master.bootsecurity.security;

import com.master.bootsecurity.entity.Role;
import com.master.bootsecurity.entity.User;
import com.master.bootsecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repo.findByUserName(s);
        if(user == null) {
            throw new UsernameNotFoundException("user not found for username"+s);
        }
        List<Role> roles = user.getRoles();
        for(Role r:roles){
            r.setName("ROLE_"+r.getName());
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);

    }
}
