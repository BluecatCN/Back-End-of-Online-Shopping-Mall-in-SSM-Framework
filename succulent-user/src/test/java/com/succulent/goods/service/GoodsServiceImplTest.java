package com.succulent.goods.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.succulent.goods.SucculentGoodsApplicationTests;
import com.succulent.goods.controller.GoodsController;
import com.succulent.goods.entity.GoodsIdentity;
import com.succulent.goods.repository.GoodsIdentityRepository;
import com.succulent.user.SucculentUserApplication;
import com.succulent.user.SucculentUserApplicationTests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import static org.junit.Assert.*;
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ContextConfiguration(classes = {GoodsServiceImplTest.class})
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SucculentUserApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//
//@WebAppConfiguration
public class GoodsServiceImplTest{

    @Resource
    private GoodsServiceImpl goodsServiceImpl;
    @Resource
    private GoodsIdentityRepository goodsIdentityRepository;
    public static ObjectMapper mapper = new ObjectMapper();

    static {
        // 转换为格式化的json
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // 如果json中有新增的字段并且是实体类类中不存在的，不报错
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    @Test
    public void query() throws JsonProcessingException {
        GoodsIdentity dto=new GoodsIdentity();
        dto.setId("123");
        Object query=goodsServiceImpl.query(dto);
        String jsonStr = mapper.writeValueAsString(query);
        System.out.println("Respbody：" + jsonStr);
    }

    @Test
    public void create() {
    }

    @Test
    public void updateById() {
    }
}