package com.buchstadt.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buchstadt.pojo.BuchComment;
import com.buchstadt.mapper.BuchCommentMapper;
import com.buchstadt.pojo.vo.BuchCommentVo;
import com.buchstadt.utils.R;
import com.buchstadt.utils.HttpCodes;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class BuchCommentService extends ServiceImpl<BuchCommentMapper, BuchComment> {

    @Resource
    private BuchCommentMapper mapper;

    public R<List<BuchComment>> queryAll(BuchCommentVo vo) {
        return R.build(HttpCodes.OK, mapper.queryAll(vo));
    }

    @Transactional
    public R<Object> insertOne(BuchComment data, Integer uid) {
        BuchComment one = super.query().eq("buch_id", data.getBuchId()).eq("user_id", uid).one();
        if (!Objects.isNull(one)) return R.build(HttpCodes.NO, "您已经插入了一条评论！");

        int f = mapper.insertOne(data, uid);
        if (f == 0)
            return R.build(HttpCodes.NO, "插入评论失败！");
        return R.build(HttpCodes.OK, "插入评论成功！");
    }

    public R<Object> deleteOne(BuchCommentVo vo) {
        int f = mapper.deleteOne(vo);
        if (f == 0) {
            return R.build(HttpCodes.NO, "删除评论失败！");
        } else {
            return R.build(HttpCodes.OK, "删除评论成功！");
        }
    }
}
