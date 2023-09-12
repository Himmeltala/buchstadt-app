package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.Pub;
import com.buchstadt.pojo.dto.PubSelectOptionDto;
import com.buchstadt.service.IPubService;
import com.buchstadt.utils.R;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @package: com.buchstadt.controller
 * @author: zheng
 * @date: 2023/8/25
 */
@GlobalUrl("/pub")
@RequiredArgsConstructor
public class PubController {

    private final IPubService service;

    /**
     * 查询一个出版社
     *
     * @param id 出版社 id
     */
    @GetMapping("/public/query/one")
    public R<Pub> queryOne(@RequestParam Integer id) {
        return service.queryOne(id);
    }

    /**
     * 查询所有出版社
     */
    @GetMapping("/auth/query/all")
    public R<List<Pub>> queryAll() {
        return service.queryAll();
    }

    /**
     * 根据页码查询出版社
     *
     * @param pageSize 页码数量
     * @param currPage 当前页数
     */
    @GetMapping("/auth/query/all-by-page")
    public R<PageInfo<Pub>> queryAllByPage(@RequestParam Integer pageSize,
                                           @RequestParam Integer currPage) {
        return service.queryAllByPage(pageSize, currPage);
    }

    /**
     * 更新出版社信息
     *
     * @param data 出版社实体类
     */
    @PutMapping("/auth/update/one")
    public R<Integer> updateOne(@RequestBody Pub data) {
        return service.updateOne(data);
    }

    /**
     * 插入一个出版社
     *
     * @param data 出版社实体类
     */
    @PostMapping("/auth/insert/one")
    public R<Integer> insertOne(@RequestBody Pub data) {
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
    public R<List<PubSelectOptionDto>> queryPublisherSelectOption() {
        return service.queryPublisherSelectOption();
    }

}
