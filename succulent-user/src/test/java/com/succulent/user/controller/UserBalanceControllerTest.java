package com.succulent.user.controller;

import com.succulent.user.SucculentUserApplication;
import com.succulent.user.SucculentUserApplicationTests;
import com.succulent.user.entity.UserBalance;
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
public class UserBalanceControllerTest extends SucculentUserApplicationTests {
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private UserBalanceController userBalanceController;

    private MockMvc mockMvc;
    @Before
    public void setupMockMvc() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userBalanceController).build();
    }
    @Test
    public void query() throws Exception{
        UserBalance userBalance=new UserBalance();
        userBalance.setUid("kd3ffnu73sk6gm4bs2h4rzj5iywdsxrb");
        String user=userBalance.getUid();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("http://localhost:8080/user/balance")
                .header("user",user)
                .contentType(MediaType.APPLICATION_JSON).content(String.valueOf(userBalance)))
                .andExpect(status().isOk()).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void addValueByUId()throws Exception {
        UserBalance userBalance=new UserBalance();
        userBalance.setUid("kd3ffnu73sk6gm4bs2h4rzj5iywdsxrb");
        userBalance.setValue(10);
        String user=userBalance.getUid();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("http://localhost:8080/user/balance")
                .header("user",user)
                .contentType(MediaType.APPLICATION_JSON).content(String.valueOf(userBalance)))
                .andExpect(status().isOk()).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void subtractValueByUId() throws Exception{
        UserBalance userBalance=new UserBalance();
        userBalance.setUid("kd3ffnu73sk6gm4bs2h4rzj5iywdsxrb");
        userBalance.setValue(0);
        String user=userBalance.getUid();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("http://localhost:8080/user/balanceSub")
                .header("user",user)
                .contentType(MediaType.APPLICATION_JSON).content(String.valueOf(userBalance)))
                .andExpect(status().isOk()).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }
}