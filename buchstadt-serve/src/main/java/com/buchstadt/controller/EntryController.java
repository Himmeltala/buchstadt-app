package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.Admin;
import com.buchstadt.pojo.User;
import com.buchstadt.service.EntryService;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@GlobalUrl("/entry")
public class EntryController {

    @Resource
    private EntryService service;

    @PostMapping("/signin")
    R<User> userSignin(@RequestBody User user) {
        return service.userSignin(user);
    }

    @PostMapping("/admin/signin")
    R<Admin> adminSignin(@RequestBody Admin admin) {
        return service.adminSignin(admin);
    }

    @PostMapping("/signup")
    R<Object> userSignup(@RequestBody User user) {
        return service.userSignup(user);
    }
}
