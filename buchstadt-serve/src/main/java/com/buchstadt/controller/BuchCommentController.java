package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.BuchComment;
import com.buchstadt.pojo.vo.BuchCommentVo;
import com.buchstadt.service.BuchCommentService;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@GlobalUrl("/buch/comment")
public class BuchCommentController {

    @Resource
    private BuchCommentService service;

    /**
     * 查询书籍的评论列表
     */
    @PostMapping("/query")
    public R<List<BuchComment>> queryAll(@RequestBody BuchCommentVo vo) {
        return service.queryAll(vo);
    }

    /**
     * 插入一条评论
     *
     * @param data 评论实体
     * @param uid  用户 ID
     */
    @PostMapping(value = "/insert")
    public R<Object> insertOne(@RequestBody BuchComment data, @RequestHeader("Uid") Integer uid) {
        return service.insertOne(data, uid);
    }

    /**
     * 删除一条评论
     */
    @PostMapping(value = "/delete")
    public R<Object> delete(@RequestBody BuchCommentVo vo) {
        return service.deleteOne(vo);
    }

}
