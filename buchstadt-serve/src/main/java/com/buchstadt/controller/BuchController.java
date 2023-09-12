package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.BCollection;
import com.buchstadt.pojo.BComment;
import com.buchstadt.pojo.Buch;
import com.buchstadt.service.IBuchService;
import com.buchstadt.service.ICollectionService;
import com.buchstadt.service.ICommentService;
import com.buchstadt.utils.R;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @package: com.buchstadt.controller
 * @author: zheng
 * @date: 2023/8/25
 */
@GlobalUrl("/buch")
@RequiredArgsConstructor
public class BuchController {

    private final IBuchService buchService;

    private final ICollectionService collectionService;

    private final ICommentService commentService;

    /**
     * 查询一条书籍信息
     *
     * @param id 书籍 id
     */
    @GetMapping("/public/query/one")
    public R<Buch> queryOne(@RequestParam Integer id) {
        return buchService.queryOne(id);
    }

    /**
     * 条件查询书籍列表
     *
     * @param isPrime  是否首推
     * @param name     书籍名称
     * @param type     书籍类型
     * @param pageSize 一页数量
     * @param currPage 页码
     */
    @GetMapping("/public/query/all")
    public R<PageInfo<Buch>> queryAllByCondition(
            @RequestParam(required = false) Integer isPrime,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) Integer currPage
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("isPrime", isPrime);
        map.put("name", name);
        map.put("type", type);
        map.put("pageSize", pageSize);
        map.put("currPage", currPage);
        return buchService.queryAllByCondition(map);
    }

    /**
     * 分页查询书籍
     *
     * @param pageSize 一页数量
     * @param currPage 页码
     */
    @GetMapping("/public/query/all-by-page")
    public R<PageInfo<Buch>> queryAllByPage(
            @RequestParam Integer pageSize,
            @RequestParam Integer currPage
    ) {
        return buchService.queryAllByPage(pageSize, currPage);
    }

    /**
     * 更新书籍信息
     *
     * @param data 书籍实体类
     */
    @PutMapping("/auth/update/one")
    public R<Void> updateOne(@RequestBody Buch data) {
        return buchService.updateOne(data);
    }

    /**
     * 插入一个书籍
     *
     * @param data 书籍实体类
     */
    @PostMapping("/auth/insert/one")
    public R<Void> insertOne(@RequestBody Buch data) {
        return buchService.insertOne(data);
    }

    /**
     * 添加书籍的附表数据
     *
     * @param data 书籍实体类
     */
    @PostMapping("/auth/insert/one-attach")
    public R<Void> insertOneAttach(@RequestBody Buch data) {
        return buchService.insertOneAttach(data);
    }

    /**
     * 删除书籍下的一个标签
     *
     * @param tagId  标签 id
     * @param buchId 书籍 id
     */
    @DeleteMapping("/auth/delete/one-tag")
    public R<Void> deleteOneTag(@RequestParam Integer tagId,
                                @RequestParam Integer buchId) {
        return buchService.deleteOneTag(tagId, buchId);
    }

    /**
     * 删除书籍下的一个作者
     *
     * @param authorId 作者 id
     * @param buchId   书籍 id
     */
    @DeleteMapping("/auth/delete/one-author")
    public R<Void> delteOneAuthor(@RequestParam Integer authorId,
                                  @RequestParam Integer buchId) {
        return buchService.deleteOneAuthor(authorId, buchId);
    }

    /**
     * 删除书籍下的一个预览图
     *
     * @param previewId 预览图 id
     * @param buchId    书籍 id
     */
    @DeleteMapping("/auth/delete/one-preview")
    public R<Void> deleteOnePreview(@RequestParam Integer previewId,
                                    @RequestParam Integer buchId) {
        return buchService.deleteOnePreview(previewId, buchId);
    }

    /**
     * 删除一个书籍
     *
     * @param id 书籍 id
     */
    @DeleteMapping("/auth/delete/one")
    public R<Void> deleteOne(@RequestParam Integer id) {
        return buchService.deleteOne(id);
    }

    /**
     * 收藏书籍
     *
     * @param buchId 书籍 id
     * @param uid    用户 id
     */
    @PostMapping("/auth/insert/one-collection")
    public R<Void> insertOneCollection(@RequestParam Integer buchId,
                                       @RequestHeader("Uid") Integer uid) {
        return collectionService.insertOneCollection(buchId, uid);
    }

    /**
     * 查询所有收藏的书籍
     *
     * @param uid 用户 id
     */
    @GetMapping("/auth/query/all-collection")
    public R<List<BCollection>> queryAllCollection(@RequestHeader("Uid") Integer uid) {
        return collectionService.queryAllCollection(uid);
    }

    /**
     * 根据条件查询所有评论
     *
     * @param id     根据书籍 id 查询评论
     * @param type   根据书籍类型查询评论
     * @param diggOp 根据书籍赞成类型查询
     * @param buryOp 根据书籍反对类型查询
     * @param digg   根据书籍赞成数量查询，与 diggOp 搭配使用
     * @param bury   根据书籍反对数量查询，与 buryOp 搭配使用
     */
    @GetMapping("/public/query/all-comment")
    public R<List<BComment>> queryAllCommentByCondition(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String diggOp,
            @RequestParam(required = false) String buryOp,
            @RequestParam(required = false) Integer digg,
            @RequestParam(required = false) Integer bury
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("type", type);
        map.put("diggOp", diggOp);
        map.put("buryOp", buryOp);
        map.put("digg", digg);
        map.put("bury", bury);
        return commentService.queryAllComment(map);
    }

    /**
     * 插入一条评论
     *
     * @param data 评论实体类
     * @param uid  用户 id
     */
    @PostMapping(value = "/auth/insert/one-comment")
    public R<Void> insertOneComment(@RequestBody BComment data,
                                    @RequestHeader("Uid") Integer uid) {
        return commentService.insertOneComment(data, uid);
    }

    /**
     * 删除一条评论
     *
     * @param id 评论 id
     */
    @DeleteMapping(value = "/auth/delete/one-comment")
    public R<Void> deleteOneComment(@RequestParam Integer id) {
        return commentService.deleteOneComment(id);
    }

}
