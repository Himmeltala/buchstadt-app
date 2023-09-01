package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.Admin;
import com.buchstadt.service.AdminService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@GlobalUrl("/admin")
public class AdminController {

    @Resource
    private AdminService service;

    /**
     * 查询所有管理员
     */
    @PostMapping("/query/all")
    public List<Admin> queryAll() {
        return service.queryAll();
    }

    /**
     * 删除某个管理员
     */
    @PostMapping("/delete")
    public Integer delete(@RequestBody Admin admin) {
        return service.delete(admin);
    }

    /**
     * 更新某个管理员
     */
    @PostMapping("/update")
    public Integer update(@RequestBody Admin admin) {
        return service.update(admin);
    }

    /**
     * 插入一个管理员
     */
    @PostMapping("/insert")
    public Integer insert(@RequestBody Admin admin) {
        return service.insert(admin);
    }

}
