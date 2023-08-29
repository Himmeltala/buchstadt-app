package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.Order;
import com.buchstadt.service.OrderService;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@GlobalUrl("/order")
public class OrderController {

    @Resource
    private OrderService service;

    @PostMapping("/query")
    R<List<Order>> query(@RequestBody(required = false) Map<String, Object> map) {
        return service.query(map);
    }

    @PostMapping("/delete")
    R<Object> delete(@RequestBody Map<String, Object> map) {
        return service.delete(map);
    }

    @PostMapping("/update")
    R<Object> update(@RequestBody Map<String, Object> map, @RequestParam("id") Integer id) {
        return service.update(map, id);
    }

}
