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

    @PostMapping("/query")
    public R<Buch> query(@RequestBody Buch data) {
        return R.build(Http.OK, service.queryOne(data));
    }

    @PostMapping("/query/all")
    public R<List<Buch>> queryAll(@RequestBody(required = false) BuchQueryVo vo) {
        return R.build(Http.OK, service.queryAll(vo));
    }

    @PostMapping("/update")
    public R<Void> update(@RequestBody Buch data) {
        return service.updateOne(data);
    }

    @PostMapping("/insert")
    public R<Void> insert(@RequestBody Buch data) {
        return service.insertOne(data);
    }


    @PostMapping("/insert/attach")
    public R<Void> insertOneAttach(@RequestBody Buch data) {
        return service.insertOneAttach(data);
    }

    @PostMapping("/delete/tag")
    public R<Void> deleteOneTag(@RequestBody Buch.Tag data) {
        return service.deleteOneTag(data);
    }

    @PostMapping("/delete/author")
    public R<Void> delteOneAuthor(@RequestBody Buch.Author data) {
        return service.deleteOneAuthor(data);
    }

    @PostMapping("/delete/preview")
    public R<Void> deleteOnePreview(@RequestBody Buch.Preview data) {
        return service.deleteOnePreview(data);
    }

    @PostMapping("/delete")
    public R<Void> deleteOne(@RequestBody Buch data) {
        return service.deleteOne(data);
    }
}
