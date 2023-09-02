package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.BuchComment;
import com.buchstadt.pojo.vo.BuchCommentVo;
import com.buchstadt.service.BuchCommentService;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@GlobalUrl("/buch-comment")
public class BuchCommentController {

    @Resource
    private BuchCommentService service;

    @PostMapping("/query")
    public R<List<BuchComment>> queryAll(@RequestBody BuchCommentVo vo) {
        return service.queryAll(vo);
    }

    @PostMapping(value = "/insert")
    public R<Void> insertOne(@RequestBody BuchComment data, @RequestHeader("Uid") Integer uid) {
        return service.insertOne(data, uid);
    }

    @PostMapping(value = "/delete")
    public R<Void> delete(@RequestBody BuchCommentVo vo) {
        return service.deleteOne(vo);
    }

}
