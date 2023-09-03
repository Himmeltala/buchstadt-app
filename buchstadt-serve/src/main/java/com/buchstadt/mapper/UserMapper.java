package com.buchstadt.mapper;

import com.buchstadt.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    List<User> queryAll();

    User queryOne(User data);

    Integer insertOne(User data);

    Integer updateOne(User data);

    Integer deleteOne(User data);

    User isExist(User data);
}
