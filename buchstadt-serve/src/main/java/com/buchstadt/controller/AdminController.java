package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.Admin;
import com.buchstadt.service.AdminService;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@GlobalUrl("/admin")
@Validated
public class AdminController {

    @Resource
    private AdminService service;

    /**
     * 查询所有管理员
     */
    @GetMapping("/auth/query/all")
    public R<List<Admin>> queryAll() {
        return service.queryAll();
    }

    /**
     * 删除一个管理员
     *
     * @param id 管理员 id
     */
    @DeleteMapping("/auth/delete/one")
    public R<Integer> deleteOne(@RequestParam Integer id) {
        return service.deleteOne(id);
    }

    /**
     * 更新管理员信息
     *
     * @param data 管理员实体类
     */
    @PutMapping("/auth/update/one")
    public R<Integer> updateOne(@RequestBody Admin data) {
        return service.updateOne(data);
    }

    /**
     * 插入一个新的管理员
     *
     * @param data 管理员实体类
     */
    @PostMapping("/auth/insert/one")
    public R<Integer> insertOne(@RequestBody Admin data) {
        return service.insertOne(data);
    }

}
