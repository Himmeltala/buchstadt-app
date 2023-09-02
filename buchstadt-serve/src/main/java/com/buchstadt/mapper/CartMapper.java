package com.buchstadt.mapper;

import com.buchstadt.pojo.Cart;
import com.buchstadt.pojo.vo.CartItemVo;
import com.buchstadt.pojo.vo.PayVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {

    int insertOneItem(CartItemVo vo, Integer uid);

    int deleteOneItem(CartItemVo vo, Integer uid);

    int createOrder(PayVo vo, int uid);

    int insertOrderItem(List<PayVo.Item> list);

    List<Cart> queryAll(int uid);

    int emptyCart(int uid);
}
