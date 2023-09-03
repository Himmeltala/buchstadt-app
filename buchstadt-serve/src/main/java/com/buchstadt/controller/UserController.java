package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.User;
import com.buchstadt.pojo.vo.UpdatePwdVo;
import com.buchstadt.service.UserService;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@GlobalUrl("/user")
@Validated
public class UserController {

    @Resource
    private UserService service;

    @PostMapping("/auth/query/all")
    public R<List<User>> queryAll() {
        return service.queryAll();
    }

    @PostMapping("/auth/query/one")
    public R<User> queryOne(@RequestBody User data) {
        return service.queryOne(data);
    }

    @PostMapping("/auth/insert/one")
    public R<Integer> insertOne(@RequestBody User data) {
        return service.insertOne(data);
    }

    @PostMapping("/auth/update/one")
    public R<Integer> updateOne(@RequestBody User data) {
        return service.updateOne(data);
    }

    @PostMapping("/auth/delete/one")
    public R<Void> deleteOne(@RequestBody User data) {
        return service.deleteOne(data);
    }

    @PostMapping("/auth/update/pwd")
    public R<Void> updatePwd(@RequestBody UpdatePwdVo vo, @RequestHeader("Uid") Integer uid) {
        return service.updatePwd(vo, uid);
    }

}
