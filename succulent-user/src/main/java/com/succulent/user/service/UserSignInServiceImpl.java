package com.succulent.user.service;

import com.succulent.user.common.RespBody;
import com.succulent.user.common.RespCode;
import com.succulent.user.entity.UserIdentity;
import com.succulent.user.repository.UserIdentityRepository;
import com.succulent.user.dto.SignInByPasscode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserSignInServiceImpl implements UserSignInService {

    @Resource
    UserIdentityRepository userIdentityRepository;

    @Override
    public Object byPasscode(SignInByPasscode dto) {
        UserIdentity queryUser = new UserIdentity();
        queryUser.setPasscode(dto.getPasscode());
        if (dto.getPhone() != null) {
            queryUser.setPhone(dto.getPhone());
        } else {
            return new RespBody(RespCode.FAIL);
        }
        List<UserIdentity> users = userIdentityRepository.findAll(queryUser);
        if (users.isEmpty()) {
            return new RespBody(RespCode.FAIL);
        }
        UserIdentity user = users.get(0);
        Map<String, String> body = new HashMap<String, String>(){{  //返回两个对象，用object比较复杂
            put("id", user.getId());
            put("token", user.getToken());
        }};
        return new RespBody(RespCode.SUCCESS, body);
    }

}
