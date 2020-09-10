package com.succulent.user.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.succulent.user.SucculentUserApplicationTests;
import com.succulent.user.entity.UserOrder;
import com.succulent.user.repository.UserBalanceRepository;
import com.succulent.user.repository.UserOrderRepository;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class UserOrderServiceImplTest extends SucculentUserApplicationTests {

    @Resource
    private UserOrderServiceImpl userOrderServiceImpl;
//    @Resource
//    private UserOrderRepository userOrderRepository;

    public static ObjectMapper mapper = new ObjectMapper();

    static {
        // 转换为格式化的json
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // 如果json中有新增的字段并且是实体类类中不存在的，不报错
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    @Test
    public void query() throws Exception {
        UserOrder userOrder=new UserOrder();
        userOrder.setUid("kd3ffnu73sk6gm4bs2h4rzj5iywdsxrb");
        Object query=userOrderServiceImpl.query(userOrder);
        String jsonStr = mapper.writeValueAsString(query);
        System.out.println("Respbody：" + jsonStr);
    }

    @Test
    public void insert()throws Exception {
        UserOrder userOrder=new UserOrder();
        userOrder.setUid("kd3ffnu73sk6gm4bs2h4rzj5iywdsxrb");
        userOrder.getAddressId("qndw6vgb6vxwlsrkt1o4cdbmi8put2km");
        userOrder.setPrice(20);
        Object insert=userOrderServiceImpl.insert(userOrder);
        String jsonStr = mapper.writeValueAsString(insert);
        System.out.println("Respbody：" + jsonStr);
    }
}