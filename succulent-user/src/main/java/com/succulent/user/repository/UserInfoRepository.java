package com.succulent.user.repository;

import com.succulent.user.entity.UserInfo;

import java.util.List;

public interface UserInfoRepository {

    Integer insert(UserInfo info);

    List<UserInfo> findAll(UserInfo info);

    UserInfo findByUId(String id);

}
