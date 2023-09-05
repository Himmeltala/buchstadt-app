package com.buchstadt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.buchstadt.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User queryOne(Integer id);

    Integer insertOne(User data);

    Integer updateOne(User data);

    Integer deleteOne(User data);

    User isExist(User data);

    Integer updatePwd(User data);

}
