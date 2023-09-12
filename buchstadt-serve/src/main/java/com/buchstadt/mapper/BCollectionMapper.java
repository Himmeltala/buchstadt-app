package com.buchstadt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.buchstadt.pojo.BCollection;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description:
 * @package: com.buchstadt.mapper
 * @author: zheng
 * @date: 2023/8/25
 */
@Mapper
public interface BCollectionMapper extends BaseMapper<BCollection> {

    List<BCollection> queryAll(Integer uid);

}
