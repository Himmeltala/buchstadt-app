package com.buchstadt.service;

import com.buchstadt.pojo.Pub;
import com.buchstadt.pojo.dto.PubSelectOptionDto;
import com.buchstadt.utils.R;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @description:
 * @package: com.buchstadt.service
 * @author: zheng
 * @date: 2023/9/12
 */
public interface IPubService {

    R<Pub> queryOne(Integer id);

    R<List<Pub>> queryAll();

    R<PageInfo<Pub>> queryAllByPage(Integer pageSize, Integer currPage);

    R<Integer> updateOne(Pub data);

    R<Integer> insertOne(Pub data);

    R<Void> deleteOne(Integer id);

    R<List<PubSelectOptionDto>> queryPublisherSelectOption();

}
