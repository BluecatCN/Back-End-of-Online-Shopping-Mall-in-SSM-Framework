package com.succulent.user.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.succulent.user.SucculentUserApplicationTests;
import com.succulent.user.dto.SignUpByPhone;
import com.succulent.user.entity.UserIdentity;
import com.succulent.user.entity.UserInfo;
import com.succulent.user.repository.UserBalanceRepository;
import com.succulent.user.repository.UserIdentityRepository;
import com.succulent.user.repository.UserInfoRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class UserSignUpServiceImplTest extends SucculentUserApplicationTests {
    //这里在测试方法中调用Servie中方法，自己写参数传递操作，然后运行测试类，得到返回结果输出

    @Resource
    private UserSignUpServiceImpl userSignUpServiceImpl;
    @Resource
    private UserIdentityRepository userIdentityRepository;
    @Resource
    private UserInfoRepository userInfoRepository;

    @Resource
    private UserBalanceRepository userBalanceRepository;

    public static ObjectMapper mapper = new ObjectMapper();

    static {
        // 转换为格式化的json
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // 如果json中有新增的字段并且是实体类类中不存在的，不报错
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Test
    public void testByPhone() throws Exception{
        SignUpByPhone signUpDto=new SignUpByPhone();
        signUpDto.setPasscode("18765432100");
        signUpDto.setPasscode("123456");
        Object ByPhone=userSignUpServiceImpl.byPhone(signUpDto);
        String jsonStr = mapper.writeValueAsString(ByPhone);
        System.out.println("RespBody：" + jsonStr);
    }
}
