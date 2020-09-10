package com.succulent.user.controller;

import com.succulent.user.SucculentUserApplication;
import com.succulent.user.SucculentUserApplicationTests;
import com.succulent.user.dto.SignUpByPhone;
import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SucculentUserApplication.class)
@WebAppConfiguration
public class UserSignUpControllerTest extends SucculentUserApplicationTests {
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private UserSignUpController userSignUpController;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userSignUpController).build();
    }

    @Test
    public void byPhone() throws Exception {
        SignUpByPhone signup = new SignUpByPhone();
        signup.setPhone("16000060000");
        signup.setPasscode("123456");
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("http://localhost:8080/user/signup/phone")
                .contentType(MediaType.APPLICATION_JSON).content(String.valueOf(signup)))
                .andExpect(status().isOk()).andReturn();
        System.out.println(result.getResponse().getContentAsString());


    }
}