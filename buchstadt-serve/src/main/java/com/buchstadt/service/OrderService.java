package com.buchstadt.service;

import com.buchstadt.mapper.OrderMapper;
import com.buchstadt.pojo.Order;
import com.buchstadt.utils.Http;
import com.buchstadt.utils.R;
import com.buchstadt.utils.ToUnderscore;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Resource
    private OrderMapper mapper;

    public R<List<Order>> queryAll(String status, Integer uid) {
        return R.build(Http.OK, mapper.queryAll(status, uid));
    }

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
