package com.master.bootsecurity.security.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
public class MyAuthenticationProvider implements AuthenticationProvider {


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username  = authentication.getName();
        String password = authentication.getCredentials().toString();
        if(username.equals("sai") && password.equals("praneeth")){
            return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
        }
        else {
            throw new BadCredentialsException("not a valid user");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
