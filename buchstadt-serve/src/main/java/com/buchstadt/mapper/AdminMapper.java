package com.buchstadt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.buchstadt.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

    Admin isExist(Admin data);

}
