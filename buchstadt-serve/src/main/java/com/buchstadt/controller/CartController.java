package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.Cart;
import com.buchstadt.params.PayForData;
import com.buchstadt.service.CartService;
import com.buchstadt.utils.ParamsMap;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@GlobalUrl("/cart")
public class CartController {

    @Resource
    private CartService service;

    @PostMapping("/insert")
    public R<Object> insert(@RequestBody Map<String, Object> map) {
        return service.insert(map);
    }

    @GetMapping("/query")
    public R<List<Cart>> query(@RequestParam Integer userId) {
        ParamsMap<String, Object> map = new ParamsMap<>();
        map.set("userId", userId);
        return service.query(map.getMap());
    }

    @PostMapping("/delete")
    public R<Object> delete(@RequestBody Map<String, Object> map) {
        return service.delete(map);
    }

    @PostMapping("/payfor")
    public R<Object> payFor(@RequestBody PayForData data) {
        return service.payFor(data);
    }

}
