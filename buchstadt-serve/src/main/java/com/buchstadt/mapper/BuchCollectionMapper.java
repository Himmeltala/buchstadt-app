package com.buchstadt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.buchstadt.pojo.BuchCollection;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuchCollectionMapper extends BaseMapper<BuchCollection> {

    List<BuchCollection> query(Integer uid);

}
