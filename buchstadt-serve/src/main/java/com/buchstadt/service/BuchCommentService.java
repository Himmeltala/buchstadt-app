package com.buchstadt.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buchstadt.pojo.BuchComment;
import com.buchstadt.mapper.BuchCommentMapper;
import com.buchstadt.utils.R;
import com.buchstadt.utils.HttpCodes;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BuchCommentService extends ServiceImpl<BuchCommentMapper, BuchComment> {

    private final BuchCommentMapper mapper;


    public BuchCommentService(BuchCommentMapper mapper) {
        this.mapper = mapper;
    }

    public R<List<BuchComment>> query(Map<String, Object> params) {
        return R.build(HttpCodes.OK, mapper.query(params));
    }

    public R<Object> insert(BuchComment body, Integer uid) {
        BuchComment one = super.query().eq("buch_id", body.getBuchId()).eq("user_id", uid).one();
        if (one != null) {
            return R.build(HttpCodes.NO, "您已经插入了一条评论");
        }

        int isOk = mapper.insert(body, uid);
        if (isOk == 0)
            return R.build(HttpCodes.NO, "插入评论失败");
        return R.build(HttpCodes.OK, "插入评论成功");
    }

    public R<Object> delete(Map<String, Object> body) {
        int flag = mapper.delete(body);
        if (flag == 0) {
            return R.build(HttpCodes.NO, "删除评论失败");
        } else {
            return R.build(HttpCodes.OK, "删除评论成功");
        }
    }
}
