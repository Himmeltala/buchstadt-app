package com.buchstadt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.buchstadt.pojo.BuchComment;
import com.buchstadt.pojo.vo.BuchCommentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuchCommentMapper extends BaseMapper<BuchComment> {

    List<BuchComment> queryList(BuchCommentVo vo);

    int insertComment(BuchComment body, Integer uid);

    int deleteComment(BuchCommentVo vo);

}
