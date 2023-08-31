package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.params.PublisherOpsData;
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
    public Publisher query(@RequestBody Map<String, Object> map) {
        return service.query(map);
    }

    @PostMapping("/query/all")
    public List<Publisher> queryAll() {
        return service.queryAll();
    }

    @PostMapping("/update")
    public Integer update(@RequestBody Publisher publisher) {
        return service.update(publisher);
    }

    @PostMapping("/insert")
    public Integer insert(@RequestBody Publisher publisher) {
        return service.insert(publisher);
    }

    @PostMapping("/delete")
    public R<Object> delete(@RequestBody Publisher publisher) {
        return service.delete(publisher);
    }

    @PostMapping("/query/ops")
    public List<PublisherOpsData> queryPublisherOps() {
        return service.queryPublisherOps();
    }
}
