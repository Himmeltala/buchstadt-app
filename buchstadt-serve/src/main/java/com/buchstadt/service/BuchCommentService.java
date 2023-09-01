package com.buchstadt.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buchstadt.pojo.BuchComment;
import com.buchstadt.mapper.BuchCommentMapper;
import com.buchstadt.pojo.vo.BuchCommentVo;
import com.buchstadt.utils.R;
import com.buchstadt.utils.HttpCodes;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuchCommentService extends ServiceImpl<BuchCommentMapper, BuchComment> {

    @Resource
    private BuchCommentMapper mapper;

    public R<List<BuchComment>> query(BuchCommentVo vo) {
        return R.build(HttpCodes.OK, mapper.queryList(vo));
    }

    public R<Object> insert(BuchComment body, Integer uid) {
        BuchComment one = super.query().eq("buch_id", body.getBuchId()).eq("user_id", uid).one();
        if (one != null) {
            return R.build(HttpCodes.NO, "您已经插入了一条评论");
        }

        int isOk = mapper.insertComment(body, uid);
        if (isOk == 0)
            return R.build(HttpCodes.NO, "插入评论失败");
        return R.build(HttpCodes.OK, "插入评论成功");
    }

    public R<Object> delete(BuchCommentVo vo) {
        int flag = mapper.deleteComment(vo);
        if (flag == 0) {
            return R.build(HttpCodes.NO, "删除评论失败");
        } else {
            return R.build(HttpCodes.OK, "删除评论成功");
        }
    }
}
