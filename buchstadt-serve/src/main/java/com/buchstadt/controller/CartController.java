package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.Cart;
import com.buchstadt.pojo.vo.CartItemVo;
import com.buchstadt.pojo.vo.PayVo;
import com.buchstadt.service.impl.CartServiceImpl;
import com.buchstadt.utils.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @package: com.buchstadt.controller
 * @author: zheng
 * @date: 2023/8/25
 */
@GlobalUrl("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartServiceImpl service;

    @PostMapping("/auth/insert/one-item")
    public R<Void> insertOneItem(@RequestBody CartItemVo vo,
                                 @RequestHeader("Uid") Integer uid) {
        return service.insertOneItem(vo, uid);
    }

    @GetMapping("/auth/query/all")
    public R<List<Cart>> queryAll(@RequestHeader("Uid") Integer uid) {
        return service.queryAll(uid);
    }

    @DeleteMapping("/auth/delete/one")
    public R<Void> deleteOneItem(@RequestParam Integer id,
                                 @RequestHeader("Uid") Integer uid) {
        return service.deleteOneItem(id, uid);
    }

    @PostMapping("/auth/pay")
    public R<Void> payment(@RequestBody PayVo vo,
                           @RequestHeader("Uid") Integer uid) {
        return service.payment(vo, uid);
    }

}
