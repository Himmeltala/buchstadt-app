package com.buchstadt.controller;

import com.buchstadt.annos.UnitedController;
import com.buchstadt.pojo.BuchCollection;
import com.buchstadt.service.BuchCollectionService;
import com.buchstadt.utils.R;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@UnitedController("/buch/collection")
public class BuchCollectionController {

    private final BuchCollectionService service;

    public BuchCollectionController(BuchCollectionService service) {
        this.service = service;
    }

    @PostMapping("/insert")
    public R<Integer> insert(@RequestBody Map<String, Object> map) {
        return service.insert(map);
    }

    @GetMapping("/query")
    public R<List<BuchCollection>> query(@RequestParam Integer userId) {
        return service.query(userId);
    }
}
