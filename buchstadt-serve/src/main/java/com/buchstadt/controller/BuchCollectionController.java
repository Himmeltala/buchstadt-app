package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.Buch;
import com.buchstadt.pojo.BuchCollection;
import com.buchstadt.service.BuchCollectionService;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@GlobalUrl("/buch-collection")
public class BuchCollectionController {

    @Resource
    private BuchCollectionService service;

    @PostMapping("/insert")
    public R<Void> insertOne(@RequestBody Buch data, @RequestHeader("Uid") Integer uid) {
        return service.insertOne(data, uid);
    }

    @GetMapping("/query")
    public R<List<BuchCollection>> queryAll(@RequestHeader("Uid") Integer uid) {
        return service.queryAll(uid);
    }
}
