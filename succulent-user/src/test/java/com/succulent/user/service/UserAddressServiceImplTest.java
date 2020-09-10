package com.succulent.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.succulent.user.SucculentUserApplicationTests;
import com.succulent.user.dto.SignInByPasscode;
import com.succulent.user.entity.UserAddress;
import com.succulent.user.repository.UserAddressRepository;
import com.succulent.user.repository.UserIdentityRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class UserAddressServiceImplTest extends SucculentUserApplicationTests {
    @Resource
    private UserAddressServiceImpl userAddressServiceImpl;
    @Resource
    private UserAddressRepository userAddressRepository;


    public static ObjectMapper mapper = new ObjectMapper();

    static {
        // 转换为格式化的json
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // 如果json中有新增的字段并且是实体类类中不存在的，不报错
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    @Test
    public void testQuery() throws Exception{
        UserAddress userAddress=new UserAddress();
        userAddress.setUid("kd3ffnu73sk6gm4bs2h4rzj5iywdsxrb");
        Object query=userAddressServiceImpl.query(userAddress);
        String jsonStr = mapper.writeValueAsString(query);
        System.out.println("Respbody：" + jsonStr);
    }

    @Test
    public void testFindById() throws JsonProcessingException {
        UserAddress userAddress=new UserAddress();
        userAddress.setId("6kuweubglkhl9rewarridj2gyx8gqiwo");
        Object findById=userAddressServiceImpl.findById(userAddress.getId());
        String jsonStr = mapper.writeValueAsString(findById);
        System.out.println("Respbody：" + jsonStr);
    }
    @Test
    public void testInsert() throws JsonProcessingException {
        UserAddress userAddress=new UserAddress();
        userAddress.setUid("kd3ffnu73sk6gm4bs2h4rzj5iywdsxrb");
        userAddress.setPhone("16000060000");
        userAddress.setName("Jiawei");
        userAddress.setCity("China");
        userAddress.setProvince("Guangdong");
        userAddress.setCity("Foshan");
        userAddress.setDist("Zengcheng");
        userAddress.setNote("No.1 Jianghe Road");
        userAddress.setDate((int) System.currentTimeMillis() / 1000);
        Object insertAddress=userAddressServiceImpl.insert(userAddress);
        String jsonStr = mapper.writeValueAsString(insertAddress);
        System.out.println("Respbody：" + jsonStr);
    }
    @Test
    public void testUpdateById() throws JsonProcessingException {
        UserAddress userAddress=new UserAddress();
        userAddress.setId("qndw6vgb6vxwlsrkt1o4cdbmi8put2km");
        userAddress.setUid("kd3ffnu73sk6gm4bs2h4rzj5iywdsxrb");
        userAddress.setPhone("18000080000");
        userAddress.setDate((int) System.currentTimeMillis() / 1000);
        Object updateById=userAddressServiceImpl.updateById(userAddress);
        String jsonStr = mapper.writeValueAsString(updateById);
        System.out.println("Respbody：" + jsonStr);
    }

}
