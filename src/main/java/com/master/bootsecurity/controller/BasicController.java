package com.master.bootsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping("/")
    public String Hello() {
        return "Hello sir, welcome back";
    }

    @GetMapping("/api")
    public String api() {
        return "welcome to elite api club";
    }
}
