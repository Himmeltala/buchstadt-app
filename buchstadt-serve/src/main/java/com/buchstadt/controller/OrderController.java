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

    /**
     * 查询用户的订单
     *
     * @param status 查询参数，已付款、
     * @param uid    用户 ID
     */
    @PostMapping("/query")
    R<List<Order>> query(@RequestParam(required = false) String status, @RequestHeader("Uid") Integer uid) {
        return service.query(status, uid);
    }

    /**
     * 删除历史订单
     *
     * @param id  删除订单的 ID
     * @param uid 用户 ID
     */
    @PostMapping("/delete")
    R<Object> delete(@RequestParam Integer id, @RequestHeader("Uid") Integer uid) {
        return service.delete(id, uid);
    }

    @PostMapping("/update")
    R<Object> update(@RequestBody Map<String, Object> map, @RequestParam("id") Integer id) {
        return service.update(map, id);
    }

}
