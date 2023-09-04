package com.buchstadt.mapper;

import com.buchstadt.pojo.Publisher;
import com.buchstadt.pojo.dto.PublisherSelectOptionDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PublisherMapper {

    Publisher query(Integer id);

    List<Publisher> queryAll();

    Integer update(Publisher data);

    Integer insert(Publisher data);

    Integer delete(Integer id);

    List<PublisherSelectOptionDto> queryPublisherSelectOption();
}
