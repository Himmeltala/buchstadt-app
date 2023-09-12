package com.buchstadt.service.impl;

import com.buchstadt.mapper.OrderMapper;
import com.buchstadt.pojo.Order;
import com.buchstadt.service.IOrderService;
import com.buchstadt.utils.Http;
import com.buchstadt.utils.R;
import com.buchstadt.utils.ToUnderscore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @package: com.buchstadt.service.impl
 * @author: zheng
 * @date: 2023/8/25
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final OrderMapper mapper;

    @Override
    public R<List<Order>> queryAll(String status, Integer uid) {
        return R.build(Http.OK, mapper.queryAll(status, uid));
    }

    @Override
    public R<Void> deleteOne(Integer id, Integer uid) {
        try {
            int flag = mapper.deleteOne(id, uid);
            if (flag != 0) return R.build(Http.OK, "删除成功！");
            else return R.build(Http.NO, "删除失败！");
        } catch (Exception e) {
            return R.build(Http.NO, e.getMessage());
        }
    }

    @Transactional
    @Override
    public R<Void> updateOne(Map<String, Object> map, Integer id) {
        map.remove("items");
        map.remove("id");
        ToUnderscore tu = new ToUnderscore(map);
        tu.convert();
        int f = mapper.updateOne(tu.map(), id);
        if (f != 0) return R.build(Http.OK, "更新数据成功！");
        else return R.build(Http.NO, "操作失败！");
    }
}
