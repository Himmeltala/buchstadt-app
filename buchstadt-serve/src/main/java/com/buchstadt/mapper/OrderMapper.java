package com.buchstadt.mapper;

import com.buchstadt.pojo.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface OrderMapper {

    List<Order> queryAll(String status, Integer uid);

    int deleteOne(@Param("id") Integer id, @Param("uid") Integer uid);

    int updateOne(@Param("map") Map<String, Object> map, @Param("id") Integer id);

}
