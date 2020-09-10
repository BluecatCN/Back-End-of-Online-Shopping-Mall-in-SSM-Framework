package com.succulent.user.repository;

import com.succulent.user.entity.UserBalance;

public interface UserBalanceRepository {

    Integer insert(UserBalance userBalance);

    UserBalance findByUId(UserBalance userBalance);

    Integer addValueByUId(UserBalance userBalance);

    Integer subtractValueByUId(UserBalance userBalance);

}
