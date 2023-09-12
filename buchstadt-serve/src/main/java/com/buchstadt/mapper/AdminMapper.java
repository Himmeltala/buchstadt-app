package com.buchstadt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.buchstadt.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @package: com.buchstadt.mapper
 * @author: zheng
 * @date: 2023/8/25
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

}
