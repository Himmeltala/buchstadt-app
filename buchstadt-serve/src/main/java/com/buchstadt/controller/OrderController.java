package com.buchstadt.controller;

import com.buchstadt.annos.UnitedController;
import com.buchstadt.pojo.Order;
import com.buchstadt.service.OrderService;
import com.buchstadt.utils.R;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@UnitedController("/order")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

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
