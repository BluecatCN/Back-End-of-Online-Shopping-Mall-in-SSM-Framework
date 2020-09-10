package com.succulent.goods.service;

import com.succulent.user.service.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({GoodsServiceImplTest.class,
        GoodsOrderServiceImplTest.class
     })
public class TestSuits {
    //不用写代码，只需要注解即可
}
