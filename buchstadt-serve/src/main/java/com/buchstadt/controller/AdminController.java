package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.Admin;
import com.buchstadt.service.AdminService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@CrossOrigin
@GlobalUrl("/admin")
public class AdminController {

    @Resource
    private AdminService service;

    @PostMapping("/query/all")
    public List<Admin> queryAll() {
        return service.queryAll();
    }

    @PostMapping("/delete")
    public Integer delete(@RequestBody Admin admin) {
        return service.delete(admin);
    }

    @PostMapping("/update")
    public Integer update(@RequestBody Admin admin) {
        return service.update(admin);
    }

    @PostMapping("/insert")
    public Integer insert(@RequestBody Admin admin) {
        return service.insert(admin);
    }

}
