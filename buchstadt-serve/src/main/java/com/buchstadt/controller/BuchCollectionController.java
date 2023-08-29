package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.BuchCollection;
import com.buchstadt.service.BuchCollectionService;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@GlobalUrl("/buch/collection")
public class BuchCollectionController {

    @Resource
    private BuchCollectionService service;

    @PostMapping("/insert")
    public R<Integer> insert(@RequestBody Map<String, Object> map) {
        return service.insert(map);
    }

    @GetMapping("/query")
    public R<List<BuchCollection>> query(@RequestParam Integer userId) {
        return service.query(userId);
    }
}
