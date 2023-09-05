package com.buchstadt.mapper;

import com.buchstadt.pojo.Pub;
import com.buchstadt.pojo.dto.PubSelectOptionDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PubMapper {

    Pub query(Integer id);

    List<Pub> queryAll();

    Integer update(Pub data);

    Integer insert(Pub data);

    Integer delete(Integer id);

    List<PubSelectOptionDto> queryPublisherSelectOption();
}
