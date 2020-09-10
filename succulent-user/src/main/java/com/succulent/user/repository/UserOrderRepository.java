package com.succulent.user.repository;

/**
 * 内部封装了数据查询和存储的逻辑，负责所有对象的持久化管理
 */


import com.succulent.user.entity.UserOrder;

import java.util.List;

public interface UserOrderRepository {

    Integer insert(UserOrder userOrder);

    List<UserOrder> findAll(UserOrder userOrder);

}
