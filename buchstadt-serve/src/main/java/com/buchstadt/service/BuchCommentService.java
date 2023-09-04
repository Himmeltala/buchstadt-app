package com.buchstadt.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buchstadt.pojo.BuchComment;
import com.buchstadt.mapper.BuchCommentMapper;
import com.buchstadt.utils.Http;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class BuchCommentService extends ServiceImpl<BuchCommentMapper, BuchComment> {

    @Resource
    private BuchCommentMapper mapper;

    public R<List<BuchComment>> queryAllComment(Integer id, String type,
                                                String diggOp, String buryOp,
                                                Integer digg, Integer bury) {
        return R.build(Http.OK, mapper.queryAllComment(id, type, diggOp, buryOp, digg, bury));
    }

    @Transactional
    public R<Void> insertOneComment(BuchComment data, Integer uid) {
        BuchComment one = super.query().eq("buch_id", data.getBuchId()).eq("user_id", uid).one();
        if (!Objects.isNull(one)) return R.build(Http.NO, "您已经插入了一条评论！");

        int f = mapper.insertOne(data, uid);
        if (f == 0)
            return R.build(Http.NO, "插入评论失败！");
        return R.build(Http.OK, "插入评论成功！");
    }

    public R<Void> deleteOneComment(Integer id) {
        int f = mapper.deleteOneComment(id);
        if (f == 0) {
            return R.build(Http.NO, "删除评论失败！");
        } else {
            return R.build(Http.OK, "删除评论成功！");
        }
    }

}
