package com.buchstadt.service;

import com.buchstadt.pojo.BCollection;
import com.buchstadt.utils.R;

import java.util.List;

/**
 * @description:
 * @package: com.buchstadt.service
 * @author: zheng
 * @date: 2023/9/12
 */
public interface ICollectionService {

    R<Void> insertOneCollection(Integer buchId, Integer uid);

    R<List<BCollection>> queryAllCollection(Integer uid);

}
