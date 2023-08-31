package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
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

    @PostMapping("/insert")
    public R<Object> insert(@RequestParam Integer id, @RequestHeader("Uid") Integer uid) {
        return service.insert(id, uid);
    }

    @GetMapping("/query")
    public R<List<BuchCollection>> query(@RequestHeader("Uid") Integer uid) {
        return service.query(uid);
    }
}
