package com.buchstadt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.buchstadt.pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AddressMapper extends BaseMapper<Address> {

    Integer insertOneAddress(@Param("data") Address data, @Param("uid") Integer uid);

    List<Address> queryAllAddresses(Integer uid);

}
