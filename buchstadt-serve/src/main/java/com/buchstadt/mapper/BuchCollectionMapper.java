package com.buchstadt.mapper;

import com.buchstadt.pojo.BuchCollection;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BuchCollectionMapper {

    int insert(Integer id, Integer uid);

    List<BuchCollection> query(Integer uid);

}
