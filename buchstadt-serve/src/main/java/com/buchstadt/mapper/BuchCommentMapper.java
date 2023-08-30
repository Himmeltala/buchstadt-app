package com.buchstadt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.buchstadt.pojo.BuchComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BuchCommentMapper extends BaseMapper<BuchComment> {
    List<BuchComment> query(Map<String, Object> params);

    int insert(BuchComment body, Integer uid);

    int delete(Map<String, Object> body);
}
