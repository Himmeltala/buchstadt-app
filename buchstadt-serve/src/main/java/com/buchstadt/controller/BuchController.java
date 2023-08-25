package com.buchstadt.controller;

import com.buchstadt.annos.UnitedController;
import com.buchstadt.pojo.Buch;
import com.buchstadt.service.BuchService;
import com.buchstadt.utils.ParamsMap;
import com.buchstadt.utils.R;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@UnitedController("/buch")
public class BuchController {

    private final BuchService service;

    public BuchController(BuchService service) {
        this.service = service;
    }

    @GetMapping("/query")
    public Buch query(@RequestParam Integer buchId) {
        ParamsMap<String, Object> map = new ParamsMap<>();
        map.set("buchId", buchId);
        return service.query(map.getMap());
    }

    @GetMapping("/query/all")
    public List<Buch> queryAll(@RequestParam(required = false) String buchName,
                               @RequestParam(required = false) Integer isPrime,
                               @RequestParam(required = false) String type) {
        ParamsMap<String, Object> map = new ParamsMap<>();
        map.set("buchName", buchName)
                .set("isPrime", isPrime)
                .set("type", type);
        return service.queryAll(map.getMap());
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
