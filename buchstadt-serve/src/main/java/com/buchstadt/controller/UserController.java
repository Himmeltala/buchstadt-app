package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.User;
import com.buchstadt.service.UserService;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@GlobalUrl("/user")
public class UserController {

    @Resource
    private UserService service;

    @PostMapping("/auth/query/all")
    public R<List<User>> queryAll() {
        return service.queryAll();
    }

    @PostMapping("/auth/query")
    public R<User> query(@RequestBody Map<String, Object> map) {
        return service.query(map);
    }

    @PostMapping("/auth/insert")
    public R<Integer> insert(@RequestBody User user) {
        return service.insert(user);
    }

    @PostMapping("/auth/update")
    public R<Integer> update(@RequestBody User user) {
        return service.update(user);
    }

    @PostMapping("/auth/delete")
    public R<Void> delete(@RequestBody User user) {
        return service.delete(user);
    }

}
