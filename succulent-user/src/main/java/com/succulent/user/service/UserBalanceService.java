package com.succulent.user.service;

import com.succulent.user.entity.UserAddress;
import com.succulent.user.entity.UserBalance;

public interface UserBalanceService {

    Object query(UserBalance userBalance);
    Object addValueByUId(UserBalance userBalance);
    Object subtractValueByUId(UserBalance userBalance);

}
