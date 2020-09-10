package com.succulent.user.controller;

import com.succulent.user.SucculentUserApplication;
import com.succulent.user.SucculentUserApplicationTests;
import com.succulent.user.dto.SignInByPasscode;
import com.succulent.user.dto.SignUpByPhone;
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
public class UserSignInControllerTest extends SucculentUserApplicationTests {
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private UserSignInController userSignInController;

    private MockMvc mockMvc;
    @Before
    public void setupMockMvc() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userSignInController).build();
    }
    @Test
    public void byPasscode() throws Exception{
        SignInByPasscode signIn = new SignInByPasscode();
        signIn.setPhone("16000060000");
        signIn.setPasscode("123456");
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("http://localhost:8080/user/signin/passcode")
                .contentType(MediaType.APPLICATION_JSON).content(String.valueOf(signIn)))
                .andExpect(status().isOk()).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }
}