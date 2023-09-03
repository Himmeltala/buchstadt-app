package com.buchstadt.service;

import com.buchstadt.pojo.Cart;
import com.buchstadt.mapper.CartMapper;
import com.buchstadt.pojo.vo.CartItemVo;
import com.buchstadt.pojo.vo.PayVo;
import com.buchstadt.utils.Http;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartService {

    @Resource
    private CartMapper mapper;

    public R<Void> insertOneItem(CartItemVo vo, Integer uid) {
        try {
            int flag = mapper.insertOneItem(vo, uid);

            if (flag == 0)
                return R.build(Http.NO, "加入购物车失败");
            else
                return R.build(Http.OK, "加入购物车成功");
        } catch (Exception e) {
            return R.build(Http.ERROR, e.getMessage());
        }
    }

    public R<List<Cart>> queryAll(Integer uid) {
        try {
            return R.build(Http.OK, "成功", mapper.queryAll(uid));
        } catch (Exception e) {
            return R.build(Http.ERROR, e.getMessage());
        }
    }

    public R<Void> deleteOneItem(Integer id, Integer uid) {
        try {
            int flag = mapper.deleteOneItem(id, uid);
            if (flag == 0) return R.build(Http.NO, "删除失败");
            else return R.build(Http.OK, "删除成功");
        } catch (Exception e) {
            return R.build(Http.ERROR, e.getMessage());
        }
    }

    @Transactional
    public R<Void> payment(PayVo vo, Integer uid) {
        try {
            int f1 = mapper.createOrder(vo, uid);

            List<PayVo.Item> items = vo.getItems();
            for (PayVo.Item item : items) item.setOrderId(vo.getId());

            int f2 = mapper.insertOrderItem(items);

            if (f2 == 0 || f1 == 0)
                return R.build(Http.NO, "支付失败");
            else {
                int f3 = mapper.emptyCart(uid);
                if (f3 == 0) {
                    return R.build(Http.NO, "支付失败");
                } else {
                    return R.build(Http.OK, "支付成功");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("支付数据库操作错误！");
        }
    }

}
