package com.succulent.user;

import com.succulent.user.service.UserSignUpService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
//由于是Web项目，Junit需要模拟ServletContext，因此需要给测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class SucculentUserApplicationTests {

	@Resource
	UserSignUpService userSignUpServiceImpl;

	@Before
	public void init() {
		System.out.println("Start Test-----------------");
	}
//
//	@Test
//	public void contextLoads() {
////		userSignUpServiceImpl.byPhone(null);
//	}


	@After
	public void after() {
		System.out.println("End of Test-----------------");
	}

}
