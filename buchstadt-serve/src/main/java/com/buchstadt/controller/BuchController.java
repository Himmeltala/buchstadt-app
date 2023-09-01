package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.Buch;
import com.buchstadt.pojo.vo.BuchVo;
import com.buchstadt.service.BuchService;
import com.buchstadt.utils.HttpCodes;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@GlobalUrl("/buch")
public class BuchController {

    @Resource
    private BuchService service;

    /**
     * 查询书籍
     */
    @GetMapping("/query")
    public R<Buch> query(@RequestParam Integer id) {
        return R.build(HttpCodes.OK, service.query(id));
    }

    /**
     * 查询书籍列表
     */
    @PostMapping("/query/all")
    public R<List<Buch>> queryAll(@RequestBody(required = false) BuchVo vo) {
        return R.build(HttpCodes.OK, service.queryAll(vo));
    }

    @PostMapping("/update")
    public R<Object> update(@RequestBody Buch buch) {
        return service.update(buch);
    }

    @PostMapping("/insert")
    public R<Object> insert(@RequestBody Buch buch) {
        return service.insert(buch);
    }


    @PostMapping("/insert/attach")
    public R<Object> insertAttach(@RequestBody Buch buch) {
        return service.insertAttach(buch);
    }

    @PostMapping("/delete/tag")
    public R<Integer> delTag(@RequestBody Buch.Tag tag) {
        return service.delTag(tag);
    }

    @PostMapping("/delete/author")
    public R<Integer> delAuthor(@RequestBody Buch.Author author) {
        return service.delAuthor(author);
    }

    @PostMapping("/delete/preview")
    public R<Integer> delPreview(@RequestBody Buch.Preview preview) {
        return service.delPreview(preview);
    }

    @PostMapping("/delete")
    public R<Object> delBuch(@RequestBody Buch buch) {
        return service.delBuch(buch);
    }
}
