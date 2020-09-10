package com.succulent.goods.service;
//
//import com.mall.goods.dto.OrderGen;
//import com.mall.goods.dto.OrderPay;
//import com.mall.goods.lib.entity.GoodsOrder;
//import com.mall.pay.lib.common.PayMode;
import com.succulent.goods.dto.OrderGen;
import com.succulent.goods.entity.GoodsOrder;
import com.succulent.goods.entity.OrderGoods;

public interface GoodsOrderService {

    Object query(GoodsOrder dto);

    Object genOrder(OrderGen dto) throws Exception;

    Object updateById(OrderGoods dto) throws Exception;
}
