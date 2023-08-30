package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.BuchComment;
import com.buchstadt.service.BuchCommentService;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@GlobalUrl("/buch/comment")
public class BuchCommentController {

    @Resource
    private BuchCommentService service;

    /**
     * 查询书籍的评论列表
     *
     * @param type   评论类别，好评、差评、中评
     * @param id     书籍 ID
     * @param diggOp 赞成操作符，gt、gteq、lt、lteq、eq
     * @param buryOp 反对操作符，gt、gteq、lt、lteq、eq
     * @param digg   赞成数
     * @param bury   反对数
     */
    @GetMapping("/query")
    public R<List<BuchComment>> query(@RequestParam(required = false) String type,
                                      @RequestParam(required = false) Integer id,
                                      @RequestParam(required = false) String diggOp,
                                      @RequestParam(required = false) String buryOp,
                                      @RequestParam(required = false) Integer digg,
                                      @RequestParam(required = false) Integer bury) {
        Map<String, Object> map = new HashMap<>();
        map.put("type", type);
        map.put("id", id);
        map.put("diggOp", diggOp);
        map.put("buryOp", buryOp);
        map.put("bury", bury);
        map.put("digg", digg);
        return service.query(map);
    }

    @PostMapping(value = "/insert")
    public R<Object> insert(@RequestBody BuchComment body, @RequestHeader("Uid") Integer uid) {
        return service.insert(body, uid);
    }

    @PostMapping(value = "/delete")
    public R<Object> delete(@RequestBody Map<String, Object> body) {
        return service.delete(body);
    }

}
