package com.succulent.user.service;

import com.succulent.user.dto.SignInByPasscode;

public interface UserSignInService {

    //与dao层进行交互
    //使用手机号和密码进行登录
    Object byPasscode(SignInByPasscode dto);

}
