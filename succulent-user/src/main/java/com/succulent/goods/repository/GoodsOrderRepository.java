package com.succulent.goods.repository;

//import com.mall.goods.lib.entity.GoodsOrder;
//import com.mall.goods.lib.qo.DuplicatedOrderGoodsCountQuery;
import com.succulent.goods.entity.GoodsOrder;
import com.succulent.goods.entity.OrderGoods;
import com.succulent.goods.qo.DuplicatedOrderGoodsCountQuery;

import java.util.List;

//处理和商品有关的订单，与orderGoods一起生成
public interface GoodsOrderRepository {

    Integer insert(GoodsOrder order);

    List<GoodsOrder> findAll(GoodsOrder order);

    List<GoodsOrder> findByLtDateAndStat(GoodsOrder order);

    Integer findDuplicatedOrderGoodsCount(DuplicatedOrderGoodsCountQuery qo);

    Integer updateById(OrderGoods order);

    Integer updateTransIdById(GoodsOrder order);

    Integer updateStatByTransId(GoodsOrder order);

}
