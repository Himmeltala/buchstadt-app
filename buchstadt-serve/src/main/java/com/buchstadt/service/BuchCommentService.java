package com.buchstadt.service;

import com.buchstadt.pojo.BuchComment;
import com.buchstadt.mapper.BuchCommentMapper;
import com.buchstadt.utils.R;
import com.buchstadt.utils.HttpCodes;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BuchCommentService {

    private final BuchCommentMapper mapper;


    public BuchCommentService(BuchCommentMapper mapper) {
        this.mapper = mapper;
    }

    public R<List<BuchComment>> query(Map<String, Object> params) {
        return R.build(HttpCodes.OK, mapper.query(params));
    }

    public R<Object> insert(Map<String, Object> body, Integer uid) {
        int flag = mapper.insert(body, uid);
        if (flag == 0)
            return R.build(HttpCodes.NO, "插入评论失败", flag);
        return R.build(HttpCodes.OK, "插入评论成功", flag);
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
