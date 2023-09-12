package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.Admin;
import com.buchstadt.service.IAdminService;
import com.buchstadt.utils.R;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @package: com.buchstadt.controller
 * @author: zheng
 * @date: 2023/8/25
 */
@GlobalUrl("/admin")
@Validated
@RequiredArgsConstructor
public class AdminController {

    private final IAdminService service;

    /**
     * 查询所有管理员
     */
    @GetMapping("/auth/query/all")
    public R<PageInfo<Admin>> queryAll(@RequestParam Integer pageSize,
                                       @RequestParam Integer currPage) {
        return service.queryAll(pageSize, currPage);
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
