package com.buchstadt.mapper;

import com.buchstadt.pojo.Admin;
import com.buchstadt.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EntryMapper {

    User queryUser(User user);

    Integer insertUser(User user);

    Admin queryAdmin(Admin admin);

}
