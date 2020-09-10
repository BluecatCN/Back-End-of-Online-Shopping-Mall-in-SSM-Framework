package com.succulent.user.service;

import com.succulent.user.entity.UserAddress;
import com.succulent.user.entity.UserBalance;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({UserSignUpServiceImplTest.class,
        UserSignInServiceImplTest.class,
        UserAddressServiceImplTest.class,
        UserBalanceServiceImplTest.class,
        UserOrderServiceImplTest.class})
public class TestSuits {
    //不用写代码，只需要注解即可
}
