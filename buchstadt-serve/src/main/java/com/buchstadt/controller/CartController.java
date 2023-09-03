package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.Cart;
import com.buchstadt.pojo.vo.CartItemVo;
import com.buchstadt.pojo.vo.PayVo;
import com.buchstadt.service.CartService;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@GlobalUrl("/cart")
public class CartController {

    @Resource
    private CartService service;

    @PostMapping("/auth/insert/one-item")
    public R<Void> insertOneItem(@RequestBody CartItemVo vo,
                                 @RequestHeader("Uid") Integer uid) {
        return service.insertOneItem(vo, uid);
    }

    @GetMapping("/auth/query/all")
    public R<List<Cart>> queryAll(@RequestHeader("Uid") Integer uid) {
        return service.queryAll(uid);
    }

    @PostMapping("/auth/delete/one")
    public R<Void> deleteOneItem(@RequestBody CartItemVo vo,
                                 @RequestHeader("Uid") Integer uid) {
        return service.deleteOneItem(vo, uid);
    }

    @PostMapping("/auth/pay")
    public R<Void> payment(@RequestBody PayVo vo,
                           @RequestHeader("Uid") Integer uid) {
        return service.payment(vo, uid);
    }

}
