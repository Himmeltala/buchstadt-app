package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.Buch;
import com.buchstadt.pojo.vo.BuchQueryVo;
import com.buchstadt.service.BuchService;
import com.buchstadt.utils.HttpCodes;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@GlobalUrl("/buch")
public class BuchController {

    @Resource
    private BuchService service;

    /**
     * 查询书籍
     */
    @PostMapping("/query")
    public R<Buch> query(@RequestBody Buch data) {
        return R.build(HttpCodes.OK, service.queryOne(data));
    }

    /**
     * 查询书籍列表
     */
    @PostMapping("/query/all")
    public R<List<Buch>> queryAll(@RequestBody(required = false) BuchQueryVo vo) {
        return R.build(HttpCodes.OK, service.queryAll(vo));
    }

    @PostMapping("/update")
    public R<Object> update(@RequestBody Buch data) {
        return service.updateOne(data);
    }

    @PostMapping("/insert")
    public R<Object> insert(@RequestBody Buch data) {
        return service.insertOne(data);
    }


    @PostMapping("/insert/attach")
    public R<Object> insertAttach(@RequestBody Buch data) {
        return service.insertOneAttach(data);
    }

    @PostMapping("/delete/tag")
    public R<Integer> delTag(@RequestBody Buch.Tag data) {
        return service.delTag(data);
    }

    @PostMapping("/delete/author")
    public R<Integer> delAuthor(@RequestBody Buch.Author data) {
        return service.delAuthor(data);
    }

    @PostMapping("/delete/preview")
    public R<Integer> delPreview(@RequestBody Buch.Preview data) {
        return service.delPreview(data);
    }

    @PostMapping("/delete")
    public R<Object> delBuch(@RequestBody Buch data) {
        return service.delBuch(data);
    }
}
