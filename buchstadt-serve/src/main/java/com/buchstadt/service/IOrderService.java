package com.buchstadt.service;

import com.buchstadt.pojo.Order;
import com.buchstadt.utils.R;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @package: com.buchstadt.service
 * @author: zheng
 * @date: 2023/9/12
 */
public interface IOrderService {

    R<List<Order>> queryAll(String status, Integer uid);

    R<Void> deleteOne(Integer id, Integer uid);

    R<Void> updateOne(Map<String, Object> map, Integer id);

}
