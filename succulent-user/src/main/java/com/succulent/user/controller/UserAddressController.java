package com.succulent.user.controller;

import com.succulent.user.common.RespBody;
import com.succulent.user.common.RespCode;
import com.succulent.user.entity.UserAddress;
import com.succulent.user.service.UserAddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/user")
public class UserAddressController {

    @Resource
    UserAddressService userAddressServiceImpl;

    @GetMapping(value = "/address")
    Object query(@RequestHeader(value = "user") String user,
                 UserAddress dto) { dto.setUid(user);
        return userAddressServiceImpl.query(dto); }

    @GetMapping(value = "/addressId") //根据addressId找地址
    Object findById(@RequestHeader(value = "id") String id,
                 UserAddress dto) { dto.setId(id);
        return userAddressServiceImpl.findById(id); }

    @PostMapping(value = "/address")
    Object insert(@RequestHeader("user") String user,
                  UserAddress dto) { dto.setUid(user);
        return userAddressServiceImpl.insert(dto); }

    @PutMapping(value = "/address")  //根据addressId更新对应的地址
    Object updateById(@RequestHeader("id") String id,
                      UserAddress dto) { dto.setId(id);
        if (dto.getId() == null) {
            return new RespBody(RespCode.FAIL); }
        return userAddressServiceImpl.updateById(dto);
    }

}
