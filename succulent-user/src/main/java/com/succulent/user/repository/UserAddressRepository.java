package com.succulent.user.repository;

/**
 * 内部封装了数据查询和存储的逻辑，负责所有对象的持久化管理
 */

import com.succulent.user.entity.UserAddress;

import java.util.List;

public interface UserAddressRepository {

    Integer insert(UserAddress userAddress);

    List<UserAddress> findAll(UserAddress userAddress);

    UserAddress findById(String id);

    Integer updateById(UserAddress userAddress);

}
