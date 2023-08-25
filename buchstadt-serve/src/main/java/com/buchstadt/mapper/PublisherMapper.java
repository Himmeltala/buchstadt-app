package com.buchstadt.mapper;

import com.buchstadt.params.PublisherOpsData;
import com.buchstadt.pojo.Publisher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PublisherMapper {

    Publisher query(Map<String, Object> map);

    List<Publisher> queryAll();

    Integer update(Publisher publisher);

    Integer insert(Publisher publisher);

    Integer delete(Publisher publisher);

    List<PublisherOpsData> queryPublisherOps();
}
