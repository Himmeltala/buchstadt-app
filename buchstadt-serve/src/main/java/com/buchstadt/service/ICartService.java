package com.buchstadt.service;

import com.buchstadt.pojo.Cart;
import com.buchstadt.pojo.vo.CartItemVo;
import com.buchstadt.pojo.vo.PayVo;
import com.buchstadt.utils.R;

import java.util.List;

/**
 * @description:
 * @package: com.buchstadt.service
 * @author: zheng
 * @date: 2023/9/12
 */
public interface ICartService {

    R<Void> insertOneItem(CartItemVo vo, Integer uid);

    R<List<Cart>> queryAll(Integer uid);

    R<Void> deleteOneItem(Integer id, Integer uid);

    R<Void> payment(PayVo vo, Integer uid);
}
