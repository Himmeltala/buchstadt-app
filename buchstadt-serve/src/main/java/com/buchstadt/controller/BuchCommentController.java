package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.BuchComment;
import com.buchstadt.service.BuchCommentService;
import com.buchstadt.utils.ParamsMap;
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

    @GetMapping("/query")
    public R<List<BuchComment>> query(@RequestParam(required = false) String buchType,
                                      @RequestParam(required = false) Integer buchId,
                                      @RequestParam(required = false) String diggOp,
                                      @RequestParam(required = false) String buryOp,
                                      @RequestParam(required = false) Integer digg,
                                      @RequestParam(required = false) Integer bury) {
        Map<String, Object> map = new HashMap<>();
        map.put("buchType", buchType);
        map.put("buchId", buchId);
        map.put("diggOp", diggOp);
        map.put("buryOp", buryOp);
        map.put("bury", bury);
        map.put("digg", digg);
        return service.query(map);
    }

    @PostMapping(value = "/insert")
    public R<Object> insert(@RequestBody Map<String, Object> body) {
        return service.insert(body);
    }

    @PostMapping(value = "/delete")
    public R<Object> delete(@RequestBody Map<String, Object> body) {
        return service.delete(body);
    }

}
