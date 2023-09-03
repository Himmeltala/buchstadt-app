package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.dto.PublisherSelectOptionDto;
import com.buchstadt.pojo.Publisher;
import com.buchstadt.service.PublisherService;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@GlobalUrl("/publisher")
public class PublisherController {

    @Resource
    private PublisherService service;

    /**
     * 查询一个出版社
     *
     * @param id 出版社 id
     */
    @GetMapping("/public/query/one")
    public R<Publisher> queryOne(@RequestParam Integer id) {
        return service.queryOne(id);
    }

    /**
     * 查询所有出版社
     */
    @GetMapping("/auth/query/all")
    public R<List<Publisher>> queryAll() {
        return service.queryAll();
    }

    /**
     * 更新出版社信息
     *
     * @param data 出版社实体类
     */
    @PostMapping("/auth/update/one")
    public R<Integer> updateOne(@RequestBody Publisher data) {
        return service.updateOne(data);
    }

    /**
     * 插入一个出版社
     *
     * @param data 出版社实体类
     */
    @PostMapping("/auth/insert/one")
    public R<Integer> insertOne(@RequestBody Publisher data) {
        return service.insertOne(data);
    }

    /**
     * 删除一个出版社
     *
     * @param id 出版社 id
     */
    @DeleteMapping("/auth/delete/one")
    public R<Void> deleteOne(@RequestParam Integer id) {
        return service.deleteOne(id);
    }

    /**
     * 查询出版社作为 element-plus 组件使用
     */
    @GetMapping("/auth/query/ops")
    public R<List<PublisherSelectOptionDto>> queryPublisherSelectOption() {
        return service.queryPublisherSelectOption();
    }

}
