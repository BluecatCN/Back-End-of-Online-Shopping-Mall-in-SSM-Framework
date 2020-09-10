package com.succulent.goods.repository;

//import com.mall.goods.lib.entity.OrderGoods;
import com.succulent.goods.entity.OrderGoods;

import java.util.List;

//处理一个订单中的多个商品
public interface OrderGoodsRepository {

    Integer insert(OrderGoods goods);

    List<OrderGoods> findAll(OrderGoods goods);

    List<OrderGoods> findByOrderId(String orderId);

    Integer updateById(OrderGoods goods);

}
