package com.succulent.user.controller;

import com.succulent.user.entity.UserOrder;
import com.succulent.user.service.UserOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/order")
public class UserOrderController {

    @Resource
    UserOrderService userOrderServiceImpl;

    @GetMapping
    Object query(@RequestHeader("user") String user, UserOrder dto) {
        dto.setUid(user);
        return userOrderServiceImpl.query(dto);
    }

    @PostMapping
    Object insert(@RequestHeader("user") String user,
                  UserOrder dto) {
        dto.setUid(user);
        return userOrderServiceImpl.insert(dto);
    }
}
