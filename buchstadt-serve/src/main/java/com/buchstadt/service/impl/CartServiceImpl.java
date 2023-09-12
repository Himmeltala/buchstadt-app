package com.buchstadt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buchstadt.exception.JdbcErrorException;
import com.buchstadt.mapper.CartMapper;
import com.buchstadt.pojo.Cart;
import com.buchstadt.pojo.vo.CartItemVo;
import com.buchstadt.pojo.vo.PayVo;
import com.buchstadt.service.ICartService;
import com.buchstadt.utils.Http;
import com.buchstadt.utils.R;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @package: com.buchstadt.service.impl
 * @author: zheng
 * @date: 2023/8/25
 */
@Service
@RequiredArgsConstructor
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {

    private final CartMapper mapper;

    @Override
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

    @Override
    public R<List<Cart>> queryAll(Integer uid) {
        try {
            return R.build(Http.OK, "成功", mapper.queryAll(uid));
        } catch (Exception e) {
            return R.build(Http.ERROR, e.getMessage());
        }
    }

    @Override
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
    @Override
    public R<Void> payment(PayVo vo, Integer uid) {
        try {
            List<PayVo.Item> items = vo.getItems();

            items.forEach(item -> {
                // 查询之前，校验数量是否和数据库表中数量对应
                Cart cart = super.query().eq("user_id", uid).eq("buch_id", item.getBuchId()).one();
                if (!Objects.equals(cart.getNum(), item.getNum())) {
                    // 数量不正常，就设置数据库保存的数量
                    item.setNum(cart.getNum());
                }
            });

            int f1 = mapper.createOrder(vo, uid);

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
            throw new JdbcErrorException();
        }
    }

}
