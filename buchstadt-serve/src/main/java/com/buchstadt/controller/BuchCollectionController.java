package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.Buch;
import com.buchstadt.pojo.BuchCollection;
import com.buchstadt.service.BuchCollectionService;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@GlobalUrl("/buch/collection")
public class BuchCollectionController {

    @Resource
    private BuchCollectionService service;

    /**
     * 插入一条评论
     *
     * @param uid 用户 ID
     */
    @PostMapping("/insert")
    public R<Object> insert(@RequestBody Buch data, @RequestHeader("Uid") Integer uid) {
        return service.insert(data, uid);
    }

    /**
     * 查询收藏的书籍
     *
     * @param uid 用户 ID
     */
    @GetMapping("/query")
    public R<List<BuchCollection>> query(@RequestHeader("Uid") Integer uid) {
        return service.query(uid);
    }
}
