package com.buchstadt.service;

import com.buchstadt.pojo.Order;
import com.buchstadt.mapper.OrderMapper;
import com.buchstadt.utils.HttpCodes;
import com.buchstadt.utils.R;
import com.buchstadt.utils.ToUnderscore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private final OrderMapper mapper;

    public OrderService(OrderMapper mapper) {
        this.mapper = mapper;
    }

    public R<List<Order>> query(Map<String, Object> map) {
        return R.build(HttpCodes.OK, mapper.query(map));
    }

    public R<Object> delete(Map<String, Object> map) {
        try {
            int flag = mapper.delete(map);
            if (flag != 0) return R.build(HttpCodes.OK, "删除成功");
            else return R.build(HttpCodes.NO, "删除失败");
        } catch (Exception e) {
            return R.build(HttpCodes.NO, e.getMessage());
        }
    }

    public R<Object> update(Map<String, Object> map, Integer id) {
        try {
            map.remove("items");
            map.remove("id");
            ToUnderscore tu = new ToUnderscore(map);
            tu.convert();
            int flag = mapper.update(tu.map(), id);
            if (flag != 0) return R.build(HttpCodes.OK, "更新数据成功");
            else return R.build(HttpCodes.NO, "操作失败");
        } catch (Exception e) {
            return R.build(HttpCodes.NO, e.getMessage());
        }
    }
}
