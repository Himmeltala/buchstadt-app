package com.buchstadt.mapper;

import com.buchstadt.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    List<User> queryAll();

    User query(Map<String, Object> map);

    Integer insert(User user);

    Integer update(User user);

    Integer delete(User user);

}
