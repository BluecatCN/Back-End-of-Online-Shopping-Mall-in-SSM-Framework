package com.succulent.user.controller;

import com.succulent.user.dto.SignUpByPhone;
import com.succulent.user.service.UserSignUpService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 实现注册流程
 */

@RestController()   //相当于@Controller+@RequestBody
@RequestMapping(value = "/user/signup")
public class UserSignUpController {

    @Resource
    UserSignUpService userSignUpServiceImpl;

    @PostMapping(value = "/phone")
    Object byPhone(SignUpByPhone dto) {
        return userSignUpServiceImpl.byPhone(dto);
    }

}
