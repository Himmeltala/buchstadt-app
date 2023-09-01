package com.buchstadt.service;

import com.buchstadt.pojo.Cart;
import com.buchstadt.mapper.CartMapper;
import com.buchstadt.pojo.vo.CartItemVo;
import com.buchstadt.pojo.vo.PayVo;
import com.buchstadt.utils.HttpCodes;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartService {

    @Resource
    private CartMapper mapper;

    public R<Object> insertItem(CartItemVo vo, Integer uid) {
        try {
            int flag = mapper.insertItem(vo, uid);

            if (flag == 0)
                return R.build(HttpCodes.NO, "加入购物车失败");
            else
                return R.build(HttpCodes.OK, "加入购物车成功");
        } catch (Exception e) {
            return R.build(HttpCodes.ERROR, e.getMessage());
        }
    }

    public R<List<Cart>> query(Integer uid) {
        try {
            return R.build(HttpCodes.OK, "成功", mapper.queryCartList(uid));
        } catch (Exception e) {
            return R.build(HttpCodes.ERROR, e.getMessage());
        }
    }

    public R<Object> delete(CartItemVo vo, Integer uid) {
        try {
            int flag = mapper.deleteItem(vo, uid);
            if (flag == 0) return R.build(HttpCodes.NO, "删除失败");
            else return R.build(HttpCodes.OK, "删除成功");
        } catch (Exception e) {
            return R.build(HttpCodes.ERROR, e.getMessage());
        }
    }

    @Transactional
    public R<Object> payment(PayVo vo, Integer uid) {
        int f1 = mapper.insertOrder(vo, uid);

        List<PayVo.Item> items = vo.getItems();
        for (PayVo.Item item : items) item.setOrderId(vo.getId());

        int f2 = mapper.insertOrderItem(items);

        if (f2 == 0 || f1 == 0)
            return R.build(HttpCodes.NO, "支付失败");
        else {
            int f3 = mapper.emptyCart(uid);
            if (f3 == 0) {
                return R.build(HttpCodes.NO, "支付失败");
            } else {
                return R.build(HttpCodes.OK, "支付成功");
            }
        }
    }

}
