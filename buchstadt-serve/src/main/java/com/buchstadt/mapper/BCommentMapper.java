package com.buchstadt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.buchstadt.pojo.BComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BCommentMapper extends BaseMapper<BComment> {

    List<BComment> queryAllComment(Map<String, Object> map);

    int insertOne(@Param("data") BComment data, Integer uid);

    int deleteOneComment(Integer id);

}
