package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.Admin;
import com.buchstadt.service.AdminService;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@GlobalUrl("/admin")
public class AdminController {

    @Resource
    private AdminService service;

    @PostMapping("/auth/query/all")
    public R<List<Admin>> queryAll() {
        return service.queryAll();
    }

    @PostMapping("/auth/delete/one")
    public R<Integer> deleteOne(@RequestBody Admin data) {
        return service.deleteOne(data);
    }

    @PostMapping("/auth/update/one")
    public R<Integer> updateOne(@RequestBody Admin data) {
        return service.updateOne(data);
    }

    @PostMapping("/auth/insert/one")
    public R<Integer> insertOne(@Validated @RequestBody Admin data) {
        return service.insertOne(data);
    }

}
