package com.buchstadt.mapper;

import com.buchstadt.pojo.BuchComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BuchCommentMapper {
    List<BuchComment> query(Map<String, Object> params);

    int insert(Map<String, Object> body);

    int delete(Map<String, Object> body);
}
