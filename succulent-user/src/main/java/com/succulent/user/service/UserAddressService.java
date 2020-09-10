package com.succulent.user.service;

import com.succulent.user.entity.UserAddress;

public interface UserAddressService {

    Object query(UserAddress userAddress);

    Object findById(String id); //根据addressId找寻对应的address

    Object insert(UserAddress userAddress);

    Object updateById(UserAddress userAddress);

}
