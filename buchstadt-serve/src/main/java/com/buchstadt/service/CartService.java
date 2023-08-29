package com.buchstadt.service;

import com.buchstadt.pojo.Cart;
import com.buchstadt.mapper.CartMapper;
import com.buchstadt.params.PayForData;
import com.buchstadt.utils.HttpCodes;
import com.buchstadt.utils.R;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CartService {

    private final CartMapper mapper;

    public CartService(CartMapper mapper) {
        this.mapper = mapper;
    }

    public R<Object> insert(Integer id, Integer num, Integer uid) {
        try {
            int flag = mapper.insert(id, num, uid);
            if (flag == 0) return R.build(HttpCodes.NO, "加入购物车失败");
            else return R.build(HttpCodes.OK, "加入购物车成功");
        } catch (Exception e) {
            return R.build(HttpCodes.ERROR, e.getMessage());
        }
    }

    public R<List<Cart>> query(Map<String, Object> map) {
        try {
            return R.build(HttpCodes.OK, "成功", mapper.query(map));
        } catch (Exception e) {
            return R.build(HttpCodes.ERROR, e.getMessage());
        }
    }

    public R<Object> delete(Integer id) {
        try {
            int flag = mapper.delete(id);
            if (flag == 0) return R.build(HttpCodes.NO, "删除失败");
            else return R.build(HttpCodes.OK, "删除成功");
        } catch (Exception e) {
            return R.build(HttpCodes.ERROR, e.getMessage());
        }
    }

    public R<Object> pay(PayForData payData, Integer uid) {
        try {
            payData.setUserId(uid);
            int flag1 = mapper.insertOrder(payData);
            List<PayForData.Item> items = payData.getItems();
            for (PayForData.Item item : items) {
                item.setOrderId(payData.getId());
            }
            int flag2 = mapper.insertOrderBuchs(items);
            if (flag2 == 0 || flag1 == 0) return R.build(HttpCodes.NO, "失败");
            else {
                int flag3 = mapper.empty(payData.getUserId());
                if (flag3 == 0) {
                    return R.build(HttpCodes.NO, "失败");
                } else {
                    return R.build(HttpCodes.OK, "支付成功");
                }
            }
        } catch (Exception e) {
            return R.build(HttpCodes.ERROR, e.getMessage());
        }
    }

}
