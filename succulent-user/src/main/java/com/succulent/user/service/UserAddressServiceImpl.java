package com.succulent.user.service;

import com.succulent.user.common.RandomUtil;
import com.succulent.user.common.RespBody;
import com.succulent.user.common.RespCode;
import com.succulent.user.entity.UserAddress;
import com.succulent.user.repository.UserAddressRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Service接口的实现
 *
 */

@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Resource
    UserAddressRepository userAddressRepository;

    @Override
    public Object query(UserAddress userAddress) {
        return new RespBody(RespCode.SUCCESS, userAddressRepository.findAll(userAddress));
    }

    @Override
    public Object findById(String id) {
        return new RespBody(RespCode.SUCCESS, userAddressRepository.findById(id));
    }

    @Override
    public Object insert(UserAddress userAddress) {
        userAddress.setId(RandomUtil.genObjectId());
        userAddress.setDate((int) System.currentTimeMillis() / 1000);
        return new RespBody(RespCode.SUCCESS, userAddressRepository.insert(userAddress));
    }

    @Override
    public Object updateById(UserAddress userAddress) {
        userAddress.setDate((int) System.currentTimeMillis() / 1000);
        return new RespBody(RespCode.SUCCESS, userAddressRepository.updateById(userAddress));
    }

}
