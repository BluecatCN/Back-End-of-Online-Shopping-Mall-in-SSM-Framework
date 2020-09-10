package com.succulent.user.controller;

import com.succulent.user.dto.SignInByPasscode;
import com.succulent.user.service.UserSignInService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 实现登录验证
 */
@Controller
@RequestMapping(value = "/user/signin") ///接口注解
public class UserSignInController {

    @Resource
    UserSignInService userSignInServiceImpl;

    @PostMapping(value = "/passcode")
    @ResponseBody
    Object byPasscode(SignInByPasscode dto) {
        return userSignInServiceImpl.byPasscode(dto);
    }

}
