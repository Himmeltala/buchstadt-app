package com.buchstadt.mapper;

import com.buchstadt.pojo.Admin;
import com.buchstadt.pojo.User;
import com.buchstadt.pojo.vo.SignUpVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EntryMapper {

    User queryUser(User user);

    User userIsExist(String username);

    Admin adminIsExist(String username);

    Integer insertUser(SignUpVo vo);

    Admin queryAdmin(Admin admin);

}
