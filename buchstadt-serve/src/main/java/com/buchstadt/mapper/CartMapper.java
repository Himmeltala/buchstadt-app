package com.buchstadt.mapper;

import com.buchstadt.pojo.Cart;
import com.buchstadt.pojo.vo.PayVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CartMapper {

    int insert(Integer id, Integer num, Integer uid);

    List<Cart> query(Map<String, Object> map);

    int delete(Integer id, Integer uid);

    int empty(Integer userId);

    int insertOrder(PayVo data);

    int insertOrderBuchs(List<PayVo.Item> list);
}
