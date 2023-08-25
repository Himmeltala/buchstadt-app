package com.buchstadt.mapper;

import com.buchstadt.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    List<Admin> queryAll();

    Integer delete(Admin admin);

    Integer update(Admin admin);

    Integer insert(Admin admin);
}
