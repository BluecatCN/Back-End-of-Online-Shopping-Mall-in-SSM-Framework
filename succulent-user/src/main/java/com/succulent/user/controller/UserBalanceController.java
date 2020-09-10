package com.succulent.user.controller;

import com.succulent.user.common.RespBody;
import com.succulent.user.common.RespCode;
import com.succulent.user.entity.UserAddress;
import com.succulent.user.entity.UserBalance;
import com.succulent.user.service.UserBalanceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户账户余额
 */

@RestController
@RequestMapping(value = "/user")
public class UserBalanceController {

    @Resource
    UserBalanceService userBalanceServiceImpl;

    @GetMapping(value = "/balance")
    Object query(@RequestHeader("user") String user) {
        return userBalanceServiceImpl.query(new UserBalance(user, null, null));
    }

    @PostMapping(value = "/balance")
    Object addValueByUId(@RequestHeader("user") String user,
                      UserBalance dto) { dto.setUid(user);
        if (dto.getUid() == null) {
            return new RespBody(RespCode.FAIL); }
        return userBalanceServiceImpl.addValueByUId(dto);
    }

    @PostMapping(value = "/balanceSub")
    Object subtractValueByUId(@RequestHeader("user") String user,
                         UserBalance dto) { dto.setUid(user);
        if (dto.getUid() == null) {
            return new RespBody(RespCode.FAIL); }
        return userBalanceServiceImpl.subtractValueByUId(dto);
    }
}
