package com.master.bootsecurity.repository;

import com.master.bootsecurity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class UserRepo {

    @Autowired
    private MongoTemplate mt;

    public List<User> findUsers() {
        return mt.findAll(User.class);
    }

    public User findByUserName(String name) {
        Query query = new Query();
        User user = mt.findOne(new Query(where("username").is(name)), User.class);
        return user;
    }
}
