package com.succulent.user.service;

import com.succulent.user.entity.UserOrder;

public interface UserOrderService {

    Object query(UserOrder userOrder);

    Object insert(UserOrder userOrder);

}
