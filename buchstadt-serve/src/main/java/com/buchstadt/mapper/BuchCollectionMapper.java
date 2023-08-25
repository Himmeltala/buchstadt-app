package com.buchstadt.mapper;

import com.buchstadt.pojo.BuchCollection;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BuchCollectionMapper {

    int insert(Map<String, Object> map);

    List<BuchCollection> query(Integer userId);

}
