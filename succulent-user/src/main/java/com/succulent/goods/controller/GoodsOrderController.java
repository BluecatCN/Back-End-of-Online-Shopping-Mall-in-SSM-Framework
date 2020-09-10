package com.succulent.goods.controller;

//import com.mall.goods.dto.OrderGen;
//import com.mall.goods.dto.OrderPay;
//import com.mall.goods.lib.entity.GoodsOrder;
//import com.mall.goods.service.GoodsOrderService;
//import com.mall.lib.response.RespBody;
//import com.mall.lib.response.RespCode;
import com.succulent.goods.entity.GoodsOrder;
import com.succulent.goods.entity.OrderGoods;
import com.succulent.goods.entity.OrderStat;
import com.succulent.user.common.RespBody;
import com.succulent.user.common.RespCode;
import com.succulent.goods.dto.OrderGen;
import com.succulent.goods.entity.GoodsIdentity;
import com.succulent.goods.service.GoodsOrderService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RequestMapping(value = "/com/succulent/goods/order")
@RestController
public class GoodsOrderController {

    @Resource
    GoodsOrderService goodsOrderServiceImpl;

    @GetMapping
    public Object query(GoodsOrder dto,
                        @RequestHeader String user) {
        dto.setUid(user);
        return goodsOrderServiceImpl.query(dto);
    }

    @PostMapping
    public Object genOrder(OrderGen dto,
                           @RequestHeader String user) throws Exception {
        if (dto.getSku() == null)
            return new RespBody(RespCode.PARAM_ERROR);
        dto.setUid(user);
        return goodsOrderServiceImpl.genOrder(dto);
    }

    @PutMapping
    Object updateById(OrderGoods dto, OrderStat stat) throws Exception {
        dto.setStat(stat.getValue());  //get the value of state of order
        return goodsOrderServiceImpl.updateById(dto);
    };
}
