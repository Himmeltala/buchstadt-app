package com.buchstadt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.buchstadt.pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @package: com.buchstadt.mapper
 * @author: zheng
 * @date: 2023/9/4
 */
@Mapper
public interface AddressMapper extends BaseMapper<Address> {

    Integer insertOneAddress(@Param("data") Address data, @Param("uid") Integer uid);

}
