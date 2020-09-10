package com.succulent.user.controller;

import com.succulent.user.service.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({UserSignUpControllerTest.class,
        UserSignInControllerTest.class,
        UserAddressControllerTest.class,
        UserBalanceControllerTest.class,
        UserOrderControllerTest.class})
public class TestSuits {
    //不用写代码，只需要注解即可
}
