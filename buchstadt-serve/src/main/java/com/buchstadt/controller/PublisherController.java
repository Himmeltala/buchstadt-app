package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.dto.PublisherSelectOptionDto;
import com.buchstadt.pojo.Publisher;
import com.buchstadt.service.PublisherService;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@GlobalUrl("/publisher")
public class PublisherController {

    @Resource
    private PublisherService service;

    @PostMapping("/query")
    public Publisher queryOne(@RequestBody Map<String, Object> map) {
        return service.queryOne(map);
    }

    @PostMapping("/query/all")
    public List<Publisher> queryAll() {
        return service.queryAll();
    }

    @PostMapping("/update")
    public R<Integer> updateOne(@RequestBody Publisher data) {
        return service.updateOne(data);
    }

    @PostMapping("/insert")
    public R<Integer> insertOne(@RequestBody Publisher data) {
        return service.insertOne(data);
    }

    @PostMapping("/delete")
    public R<Void> deleteOne(@RequestBody Publisher data) {
        return service.deleteOne(data);
    }

    @PostMapping("/query/ops")
    public R<List<PublisherSelectOptionDto>> queryPublisherSelectOption() {
        return service.queryPublisherSelectOption();
    }
}
