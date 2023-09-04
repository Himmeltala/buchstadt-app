package com.buchstadt.mapper;

import com.buchstadt.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> queryAll();

    User queryOne(Integer id);

    Integer insertOne(User data);

    Integer updateOne(User data);

    Integer deleteOne(User data);

    User isExist(User data);

    Integer updatePwd(User data);

}
