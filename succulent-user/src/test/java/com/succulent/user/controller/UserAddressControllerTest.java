package com.succulent.user.controller;

import com.succulent.user.SucculentUserApplication;
import com.succulent.user.SucculentUserApplicationTests;
import com.succulent.user.entity.UserAddress;
import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SucculentUserApplication.class)
@WebAppConfiguration
public class UserAddressControllerTest extends SucculentUserApplicationTests {
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private UserAddressController userAddressController;

    private MockMvc mockMvc;
    @Before
    public void setupMockMvc() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userAddressController).build();
    }
    @Test
    public void query() throws Exception {
        UserAddress userAddress=new UserAddress();
        userAddress.setUid("kd3ffnu73sk6gm4bs2h4rzj5iywdsxrb");
        String user=userAddress.getUid();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("http://localhost:8080/user/address")
                .header("user",user)
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(userAddress))).andExpect(status().isOk()).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void findById() throws Exception {
        UserAddress userAddress=new UserAddress();
        userAddress.setId("6kuweubglkhl9rewarridj2gyx8gqiwo");
        String id=userAddress.getId();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("http://localhost:8080/user/addressId")
                .header("id",id)
                .contentType(MediaType.APPLICATION_JSON).content(String.valueOf(userAddress.getId())))
                .andExpect(status().isOk()).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void insert() throws Exception {
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
        String user=userAddress.getUid();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("http://localhost:8080/user/address")
                .header("user",user)
                .contentType(MediaType.APPLICATION_JSON).content(String.valueOf(userAddress)))
                .andExpect(status().isOk()).andReturn();
        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    public void updateById() throws Exception {
        UserAddress userAddress=new UserAddress();
        userAddress.setId("qndw6vgb6vxwlsrkt1o4cdbmi8put2km");
        userAddress.setUid("kd3ffnu73sk6gm4bs2h4rzj5iywdsxrb");
        userAddress.setPhone("18000080000");
        userAddress.setDate((int) System.currentTimeMillis() / 1000);
        String id=userAddress.getId();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .put("http://localhost:8080/user/address")
                .header("id",id)
                .contentType(MediaType.APPLICATION_JSON).content(String.valueOf(userAddress)))
                .andExpect(status().isOk()).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }
}