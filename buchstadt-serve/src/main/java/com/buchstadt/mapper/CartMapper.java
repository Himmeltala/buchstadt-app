package com.buchstadt.mapper;

import com.buchstadt.pojo.Cart;
import com.buchstadt.pojo.vo.CartItemVo;
import com.buchstadt.pojo.vo.PayVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {

    int insertItem(CartItemVo vo, Integer uid);

    int deleteItem(CartItemVo vo, Integer uid);

    int insertOrder(PayVo vo, int uid);

    int insertOrderItem(List<PayVo.Item> list);

    List<Cart> queryCartList(int uid);

    int emptyCart(int uid);
}
