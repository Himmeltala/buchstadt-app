package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.Buch;
import com.buchstadt.pojo.vo.BuchQueryVo;
import com.buchstadt.service.BuchService;
import com.buchstadt.utils.Http;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@GlobalUrl("/buch")
public class BuchController {

    @Resource
    private BuchService service;

    @PostMapping("/public/query")
    public R<Buch> query(@RequestBody Buch data) {
        return R.build(Http.OK, service.queryOne(data));
    }

    @PostMapping("/public/query/all")
    public R<List<Buch>> queryAll(@RequestBody(required = false) BuchQueryVo vo) {
        return R.build(Http.OK, service.queryAll(vo));
    }

    @PostMapping("/auth/update")
    public R<Void> update(@RequestBody Buch data) {
        return service.updateOne(data);
    }

    @PostMapping("/auth/insert")
    public R<Void> insert(@RequestBody Buch data) {
        return service.insertOne(data);
    }


    @PostMapping("/auth/insert/attach")
    public R<Void> insertOneAttach(@RequestBody Buch data) {
        return service.insertOneAttach(data);
    }

    @PostMapping("/auth/delete/tag")
    public R<Void> deleteOneTag(@RequestBody Buch.Tag data) {
        return service.deleteOneTag(data);
    }

    @PostMapping("/auth/delete/author")
    public R<Void> delteOneAuthor(@RequestBody Buch.Author data) {
        return service.deleteOneAuthor(data);
    }

    @PostMapping("/auth/delete/preview")
    public R<Void> deleteOnePreview(@RequestBody Buch.Preview data) {
        return service.deleteOnePreview(data);
    }

    @PostMapping("/auth/delete")
    public R<Void> deleteOne(@RequestBody Buch data) {
        return service.deleteOne(data);
    }
}
