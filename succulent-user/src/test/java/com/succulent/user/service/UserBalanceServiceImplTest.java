package com.succulent.user.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.succulent.user.SucculentUserApplicationTests;
import com.succulent.user.entity.UserBalance;
import com.succulent.user.repository.UserAddressRepository;
import com.succulent.user.repository.UserBalanceRepository;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class UserBalanceServiceImplTest extends SucculentUserApplicationTests {

    @Resource
    private UserBalanceServiceImpl userBalanceServiceImpl;
    @Resource
    private UserBalanceRepository userbalanceRepository;

    public static ObjectMapper mapper = new ObjectMapper();

    static {
        // 转换为格式化的json
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // 如果json中有新增的字段并且是实体类类中不存在的，不报错
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    @Test
    public void query() throws  Exception{
        UserBalance userBalance=new UserBalance();
        userBalance.setUid("kd3ffnu73sk6gm4bs2h4rzj5iywdsxrb");
        Object query=userBalanceServiceImpl.query(userBalance);
        String jsonStr = mapper.writeValueAsString(query);
        System.out.println("Respbody：" + jsonStr);
    }

    @Test
    public void addValueByUId() throws  Exception{
        UserBalance userBalance=new UserBalance();
        userBalance.setUid("kd3ffnu73sk6gm4bs2h4rzj5iywdsxrb");
        userBalance.setValue(10);
        Object add=userBalanceServiceImpl.addValueByUId(userBalance);
        String jsonStr = mapper.writeValueAsString(add);
        System.out.println("Respbody：" + jsonStr);
    }

    @Test
    public void subtractValueByUId() throws  Exception{
        UserBalance userBalance=new UserBalance();
        userBalance.setUid("kd3ffnu73sk6gm4bs2h4rzj5iywdsxrb");
        userBalance.setValue(0);
        Object subtract=userBalanceServiceImpl.subtractValueByUId(userBalance);
        String jsonStr = mapper.writeValueAsString(subtract);
        System.out.println("Respbody：" + jsonStr);
    }
}