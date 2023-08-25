package com.buchstadt.controller;

import com.buchstadt.annos.UnitedController;
import com.buchstadt.pojo.User;
import com.buchstadt.service.UserService;
import com.buchstadt.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@UnitedController("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/query/all")
    public List<User> queryAll() {
        return service.queryAll();
    }

    @PostMapping("/query")
    public User query(@RequestBody Map<String, Object> map) {
        return service.query(map);
    }

    @PostMapping("/insert")
    public Integer insert(@RequestBody User user) {
        return service.insert(user);
    }

    @PostMapping("/update")
    public Integer update(@RequestBody User user) {
        return service.update(user);
    }

    @PostMapping("/delete")
    public R<Object> delete(@RequestBody User user) {
        return service.delete(user);
    }

}
