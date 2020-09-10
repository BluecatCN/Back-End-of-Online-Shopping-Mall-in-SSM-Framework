package com.succulent.user.service;

import com.succulent.user.common.RandomUtil;
import com.succulent.user.common.RespBody;
import com.succulent.user.common.RespCode;

import com.succulent.user.entity.UserOrder;
import com.succulent.user.repository.UserOrderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Service接口的实现
 *
 */

@Service
public class UserOrderServiceImpl implements UserOrderService{

    @Resource
    UserOrderRepository userOrderRepository;

    @Override
    public Object query(UserOrder userOrder) {
        return new RespBody(RespCode.SUCCESS, userOrderRepository.findAll(userOrder));
    }

    @Override
    public Object insert(UserOrder userOrder) {
        userOrder.setId(RandomUtil.genObjectId());
        userOrder.setDate((int) System.currentTimeMillis() / 1000);
        return new RespBody(RespCode.SUCCESS, userOrderRepository.insert(userOrder));
    }

}
