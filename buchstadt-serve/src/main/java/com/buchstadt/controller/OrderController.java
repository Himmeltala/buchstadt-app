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

    /**
     * 查询所有订单
     *
     * @param status 根据订单状态查询
     * @param uid    用户 id
     */
    @GetMapping("/auth/query/all")
    public R<List<Order>> queryAll(@RequestParam(required = false) String status,
                                   @RequestHeader("Uid") Integer uid) {
        return service.queryAll(status, uid);
    }

    /**
     * 删除一个订单
     *
     * @param id  订单 id
     * @param uid 用户 id
     */
    @DeleteMapping("/auth/delete/one")
    public R<Void> deleteOne(@RequestParam Integer id,
                             @RequestHeader("Uid") Integer uid) {
        return service.deleteOne(id, uid);
    }

    /**
     * 更新订单数据
     *
     * @param map 订单实体类，与 Order 实体类对应
     * @param id  订单 id
     */
    @PutMapping("/auth/update/one")
    public R<Void> updateOne(@RequestBody Map<String, Object> map,
                             @RequestParam("id") Integer id) {
        return service.updateOne(map, id);
    }

}
