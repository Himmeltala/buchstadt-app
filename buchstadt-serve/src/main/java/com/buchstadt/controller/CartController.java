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

    /**
     * 把书籍加入到购物车
     */
    @PostMapping("/insert")
    public R<Object> insertItem(@RequestBody CartItemVo vo, @RequestHeader("Uid") Integer uid) {
        return service.insertItem(vo, uid);
    }

    /**
     * 查询用户加入购物车的书籍
     *
     * @param uid 用户 ID
     */
    @GetMapping("/query")
    public R<List<Cart>> query(@RequestHeader("Uid") Integer uid) {
        return service.query(uid);
    }

    /**
     * 删除购物车中的书籍
     */
    @PostMapping("/delete")
    public R<Object> delete(@RequestBody CartItemVo vo, @RequestHeader("Uid") Integer uid) {
        return service.delete(vo, uid);
    }

    /**
     * 将购物车中的书本以及收货地址插入到数据库中
     *
     * @param vo  购物车书本集合以及收货地址实体类
     * @param uid 用户 ID
     */
    @PostMapping("/pay")
    public R<Object> payment(@RequestBody PayVo vo, @RequestHeader("Uid") Integer uid) {
        return service.payment(vo, uid);
    }

}
