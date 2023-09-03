package com.buchstadt.mapper;

import com.buchstadt.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    List<Admin> queryAll();

    Integer deleteOne(Admin data);

    Integer updateOne(Admin data);

    Integer insertOne(Admin data);

    Admin isExist(Admin data);

}
