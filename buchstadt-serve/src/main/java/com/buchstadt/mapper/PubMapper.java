package com.buchstadt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.buchstadt.pojo.Pub;
import com.buchstadt.pojo.dto.PubSelectOptionDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description:
 * @package: com.buchstadt.mapper
 * @author: zheng
 * @date: 2023/8/25
 */
@Mapper
public interface PubMapper extends BaseMapper<Pub> {

    Pub queryOne(Integer id);

    List<Pub> queryAll();

    Integer updateOne(Pub data);

    Integer insertOne(Pub data);

    Integer deleteOne(Integer id);

    List<PubSelectOptionDto> queryPublisherSelectOption();
}
