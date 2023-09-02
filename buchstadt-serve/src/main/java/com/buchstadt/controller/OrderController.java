package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.Order;
import com.buchstadt.service.OrderService;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@GlobalUrl("/order")
public class OrderController {

    @Resource
    private OrderService service;

    @PostMapping("/query")
    public R<List<Order>> queryAll(@RequestParam(required = false) String status, @RequestHeader("Uid") Integer uid) {
        return service.queryAll(status, uid);
    }

    @PostMapping("/delete")
    public R<Void> deleteOne(@RequestParam Integer id, @RequestHeader("Uid") Integer uid) {
        return service.deleteOne(id, uid);
    }

    @PostMapping("/update")
    public R<Void> updateOne(@RequestBody Map<String, Object> map, @RequestParam("id") Integer id) {
        return service.updateOne(map, id);
    }

}
