package com.succulent.user.controller;

import com.succulent.user.SucculentUserApplication;
import com.succulent.user.SucculentUserApplicationTests;
import com.succulent.user.entity.UserOrder;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SucculentUserApplication.class)
@WebAppConfiguration
public class UserOrderControllerTest extends SucculentUserApplicationTests {
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private UserOrderController userOrderController;

    private MockMvc mockMvc;
    @Before
    public void setupMockMvc() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userOrderController).build();
    }
    @Test
    public void query() throws Exception{
        UserOrder userOrder=new UserOrder();
        userOrder.setUid("kd3ffnu73sk6gm4bs2h4rzj5iywdsxrb");
        String user=userOrder.getUid();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("http://localhost:8080/user/order")
                .header("user",user)
                .contentType(MediaType.APPLICATION_JSON).content(String.valueOf(userOrder)))
                .andExpect(status().isOk()).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void insert()throws Exception {
        UserOrder userOrder=new UserOrder();
        userOrder.setUid("kd3ffnu73sk6gm4bs2h4rzj5iywdsxrb");
        userOrder.getAddressId("qndw6vgb6vxwlsrkt1o4cdbmi8put2km");
        userOrder.setPrice(20);
        String user=userOrder.getUid();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("http://localhost:8080/user/order")
                .header("user",user)
                .contentType(MediaType.APPLICATION_JSON).content(String.valueOf(userOrder)))
                .andExpect(status().isOk()).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }
}