package com.buchstadt.mapper;

import com.buchstadt.pojo.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface OrderMapper {

    List<Order> query(Map<String, Object> map);

    int delete(Map<String, Object> map);

    int update(@Param("map") Map<String, Object> map, @Param("id") Integer id);

}
