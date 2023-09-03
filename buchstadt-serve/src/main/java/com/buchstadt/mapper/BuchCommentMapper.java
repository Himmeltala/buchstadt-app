package com.buchstadt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.buchstadt.pojo.BuchComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BuchCommentMapper extends BaseMapper<BuchComment> {

    List<BuchComment> queryAllComment(Integer id, String type,
                                      String diggOp, String buryOp,
                                      Integer digg, Integer bury);

    int insertOne(@Param("data") BuchComment data, Integer uid);

    int deleteOneComment(Integer id);

}
