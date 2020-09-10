package com.succulent.goods.service;

//import com.mall.goods.dto.OrderGen;
//import com.mall.goods.dto.OrderPay;
//import com.mall.goods.lib.entity.GoodsIdentity;
//import com.mall.goods.lib.entity.GoodsOrder;
//import com.mall.goods.lib.entity.GoodsSku;
//import com.mall.goods.lib.entity.OrderGoods;
//import com.mall.goods.lib.qo.DuplicatedOrderGoodsCountQuery;
//import com.mall.goods.lib.qo.GoodsSkuStockUpdateById;
//import com.mall.goods.lib.repository.GoodsIdentityRepository;
//import com.mall.goods.lib.repository.GoodsOrderRepository;
//import com.mall.goods.lib.repository.GoodsSkuRepository;
//import com.mall.goods.lib.repository.OrderGoodsRepository;
//import com.mall.goods.lib.macro.GoodsStat;
//import com.mall.lib.data.IdentityCode;
//import com.mall.lib.date.util.TimeUtility;
//import com.mall.lib.exception.ServiceException;
//import com.mall.lib.response.RespBody;
//import com.mall.lib.response.RespCode;
import com.succulent.goods.entity.*;
import com.succulent.goods.repository.GoodsIdentityRepository;
import com.succulent.goods.repository.GoodsOrderRepository;
import com.succulent.goods.repository.GoodsSkuRepository;
import com.succulent.goods.repository.OrderGoodsRepository;
import com.succulent.lib.date.util.TimeUtility;
import com.succulent.user.common.RespBody;
import com.succulent.user.common.RespCode;
import com.succulent.goods.dto.OrderGen;
import com.succulent.goods.qo.GoodsSkuStockUpdateById;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodsOrderServiceImpl implements GoodsOrderService {
    private static Logger logger = LoggerFactory.getLogger(GoodsOrderServiceImpl.class);

    @Resource
    GoodsOrderRepository goodsOrderRepository;
    @Resource
    OrderGoodsRepository orderGoodsRepository;
    @Resource
    GoodsSkuRepository goodsSkuRepository;
    @Resource
    GoodsIdentityRepository goodsIdentityRepository;

    @Override
    public Object query(GoodsOrder dto) {
        return new RespBody(RespCode.SUCCESS, goodsOrderRepository.findAll(dto));
    }

    @Override
    public Object genOrder(OrderGen dto) throws Exception {
        // query sku
        GoodsSku sku = goodsSkuRepository.findById(dto.getSku());
        if (sku == null)
            return new RespBody(RespCode.IDENTITY_NULL);
        if (sku.getStock() < 1)
            return new RespBody(RespCode.GOODS_UNDERSTOCK);
        // query goods
        GoodsIdentity goods = goodsIdentityRepository.findAll(new GoodsIdentity(sku.getGoodsId())).get(0);
        if (goods.getStat() != GoodsStat.NORMAL.getValue())
            return new RespBody(RespCode.STAT_ILLEGAL);
        // goods order
        GoodsOrder order = new GoodsOrder();
        //order.setId(IdentityCode.genTimeLineId());
        order.setUid(dto.getUid());
        order.setAmount(sku.getPrice());
        order.setComment(dto.getComment());
        order.setDate(TimeUtility.getCurrentTimestampMilliSecond());
        //order.setStat(TransStat.UNPAID.getValue());
        // order goods
        OrderGoods orderGoods = new OrderGoods();
        orderGoods.setOrderId(order.getId());
        orderGoods.setSkuId(sku.getId());
        orderGoods.setQuantity(1);
        orderGoods.setAmount(sku.getPrice());
        // sku stock
        GoodsSkuStockUpdateById updateStock = new GoodsSkuStockUpdateById(sku.getId(), -1, null);
        // gen order
        if (    goodsOrderRepository.insert(order) > 0 &&
                orderGoodsRepository.insert(orderGoods) > 0 &&
                goodsSkuRepository.updateStockById(updateStock) > 0
        ) { return new RespBody(RespCode.SUCCESS, order);
        }
        throw new Exception();

                //new ServiceException(new RespBody(RespCode.FAIL));
    }

    @Override
    public Object updateById(OrderGoods dto){
        if (    dto.getOrderId() != null &&
                goodsOrderRepository.updateById(dto) > 0 &&
                orderGoodsRepository.updateById(dto) > 0
        ) { return new RespBody(RespCode.SUCCESS); }
        else
            return null;
    }

}
