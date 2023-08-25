package com.buchstadt.controller;

import com.buchstadt.annos.UnitedController;
import com.buchstadt.pojo.Admin;
import com.buchstadt.pojo.User;
import com.buchstadt.service.EntryService;
import com.buchstadt.utils.R;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@UnitedController("/entry")
public class EntryController {

    private final EntryService service;

    public EntryController(EntryService service) {
        this.service = service;
    }

    @PostMapping("/signin")
    R<User> userSignin(@RequestBody User user) {
        return service.userSignin(user);
    }

    @PostMapping("/admin/signin")
    R<Admin> adminSignin(@RequestBody Admin admin) {
        return service.adminSignin(admin);
    }

    @PostMapping("/signup")
    R<User> userSignup(@RequestBody User user) {
        return service.userSignup(user);
    }
}
