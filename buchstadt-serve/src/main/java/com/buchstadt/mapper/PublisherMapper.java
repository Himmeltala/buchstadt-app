package com.buchstadt.mapper;

import com.buchstadt.pojo.dto.PublisherSelectOptionDto;
import com.buchstadt.pojo.Publisher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PublisherMapper {

    Publisher query(Map<String, Object> map);

    List<Publisher> queryAll();

    Integer update(Publisher data);

    Integer insert(Publisher data);

    Integer delete(Publisher data);

    List<PublisherSelectOptionDto> queryPublisherSelectOption();
}
