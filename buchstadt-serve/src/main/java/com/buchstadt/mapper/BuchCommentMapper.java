package com.buchstadt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.buchstadt.pojo.BuchComment;
import com.buchstadt.pojo.vo.CommentQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BuchCommentMapper extends BaseMapper<BuchComment> {

    List<BuchComment> queryAllComment(CommentQueryVo vo);

    int insertOne(@Param("data") BuchComment data, Integer uid);

    int deleteOneComment(CommentQueryVo vo);

}
