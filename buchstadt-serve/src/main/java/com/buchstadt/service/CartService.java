package com.buchstadt.service;

import com.buchstadt.pojo.Cart;
import com.buchstadt.mapper.CartMapper;
import com.buchstadt.params.PayForData;
import com.buchstadt.utils.R;
import com.buchstadt.utils.Status;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CartService {

    private final CartMapper mapper;

    public CartService(CartMapper mapper) {
        this.mapper = mapper;
    }

    public R<Object> insert(Map<String, Object> map) {
        try {
            int flag = mapper.insert(map);
            if (flag == 0) return R.build(Status.NO, "加入购物车失败");
            else return R.build(Status.OK, "加入购物车成功");
        } catch (Exception e) {
            e.printStackTrace();
            return R.build(Status.ERROR, "服务器错误");
        }
    }

    public R<List<Cart>> query(Map<String, Object> map) {
        try {
            return R.build(Status.OK, "成功", mapper.query(map));
        } catch (Exception e) {
            e.printStackTrace();
            return R.build(Status.ERROR, "服务器错误");
        }
    }

    public R<Object> delete(Map<String, Object> map) {
        try {
            int flag = mapper.delete(map);
            if (flag == 0) return R.build(Status.NO, "删除失败");
            else return R.build(Status.OK, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return R.build(Status.ERROR, "服务器错误");
        }
    }

    public R<Object> payFor(PayForData data) {
        try {
            int flag1 = mapper.insertOrder(data);
            List<PayForData.Item> items = data.getItems();
            for (PayForData.Item item : items) {
                item.setOrderId(data.getId());
            }
            int flag2 = mapper.insertOrderBuchs(items);
            if (flag2 == 0 || flag1 == 0) return R.build(Status.NO, "失败");
            else {
                int flag3 = mapper.empty(data.getUserId());
                if (flag3 == 0) {
                    return R.build(Status.NO, "失败");
                } else {
                    return R.build(Status.OK, "支付成功");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.build(Status.ERROR, "服务器错误");
        }
    }

}
