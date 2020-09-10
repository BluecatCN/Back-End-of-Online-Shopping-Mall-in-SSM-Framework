package com.succulent.user.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.succulent.user.SucculentUserApplicationTests;
import com.succulent.user.dto.SignInByPasscode;
import com.succulent.user.dto.SignUpByPhone;
import com.succulent.user.repository.UserIdentityRepository;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class UserSignInServiceImplTest extends SucculentUserApplicationTests {
    @Resource
    private UserSignInServiceImpl userSignInServiceImpl;
    @Resource
    private UserIdentityRepository userIdentityRepository;

    public static ObjectMapper mapper = new ObjectMapper();

    static {
        // 转换为格式化的json
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // 如果json中有新增的字段并且是实体类类中不存在的，不报错
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    @Test
    public void byPasscode() throws Exception{
        SignInByPasscode signInDto=new SignInByPasscode();
        signInDto.setPhone("16000060000");
        signInDto.setPasscode("123456");
        Object ByPasscode=userSignInServiceImpl.byPasscode(signInDto);
        String jsonStr = mapper.writeValueAsString(ByPasscode);
        System.out.println("Respbody：" + jsonStr);

    }
}