package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.Buch;
import com.buchstadt.pojo.BuchCollection;
import com.buchstadt.pojo.BuchComment;
import com.buchstadt.pojo.vo.CommentQueryVo;
import com.buchstadt.pojo.vo.BuchQueryVo;
import com.buchstadt.service.BuchCollectionService;
import com.buchstadt.service.BuchCommentService;
import com.buchstadt.service.BuchService;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@GlobalUrl("/buch")
public class BuchController {

    @Resource
    private BuchService buchService;

    @Resource
    private BuchCollectionService collectionService;

    @Resource
    private BuchCommentService commentService;

    @PostMapping("/public/query/one")
    public R<Buch> queryOne(@RequestBody Buch data) {
        return buchService.queryOne(data);
    }

    @PostMapping("/public/query/all")
    public R<List<Buch>> queryAll(@RequestBody(required = false) BuchQueryVo vo) {
        return buchService.queryAll(vo);
    }

    @PostMapping("/auth/update/one")
    public R<Void> updateOne(@RequestBody Buch data) {
        return buchService.updateOne(data);
    }

    @PostMapping("/auth/insert/one")
    public R<Void> insertOne(@RequestBody Buch data) {
        return buchService.insertOne(data);
    }


    @PostMapping("/auth/insert/one-attach")
    public R<Void> insertOneAttach(@RequestBody Buch data) {
        return buchService.insertOneAttach(data);
    }

    @PostMapping("/auth/delete/one-tag")
    public R<Void> deleteOneTag(@RequestBody Buch.Tag data) {
        return buchService.deleteOneTag(data);
    }

    @PostMapping("/auth/delete/one-author")
    public R<Void> delteOneAuthor(@RequestBody Buch.Author data) {
        return buchService.deleteOneAuthor(data);
    }

    @PostMapping("/auth/delete/one-preview")
    public R<Void> deleteOnePreview(@RequestBody Buch.Preview data) {
        return buchService.deleteOnePreview(data);
    }

    @PostMapping("/auth/delete/one")
    public R<Void> deleteOne(@RequestBody Buch data) {
        return buchService.deleteOne(data);
    }

    @PostMapping("/auth/insert/one-collection")
    public R<Void> insertOneCollection(@RequestBody Buch data,
                                       @RequestHeader("Uid") Integer uid) {
        return collectionService.insertOneCollection(data, uid);
    }

    @GetMapping("/auth/query/all-collection")
    public R<List<BuchCollection>> queryAllCollection(@RequestHeader("Uid") Integer uid) {
        return collectionService.queryAllCollection(uid);
    }

    @PostMapping("/public/query/all-comment")
    public R<List<BuchComment>> queryAllComment(@RequestBody CommentQueryVo vo) {
        return commentService.queryAllComment(vo);
    }

    @PostMapping(value = "/auth/insert/one-comment")
    public R<Void> insertOneComment(@RequestBody BuchComment data,
                                    @RequestHeader("Uid") Integer uid) {
        return commentService.insertOneComment(data, uid);
    }

    @PostMapping(value = "/auth/delete/one-comment")
    public R<Void> deleteOneComment(@RequestBody CommentQueryVo vo) {
        return commentService.deleteOneComment(vo);
    }

}
