package com.buchstadt.controller;

import com.buchstadt.annos.UnitedController;
import com.buchstadt.params.PublisherOpsData;
import com.buchstadt.pojo.Publisher;
import com.buchstadt.service.PublisherService;
import com.buchstadt.utils.R;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@CrossOrigin
@UnitedController("/publisher")
public class PublisherController {

    private final PublisherService service;

    public PublisherController(PublisherService service) {
        this.service = service;
    }

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
