package com.succulent.user.repository;

import com.succulent.user.entity.UserIdentity;

import java.util.List;

public interface UserIdentityRepository {

    Integer insert(UserIdentity identity);

    List<UserIdentity> findAll(UserIdentity identity);

}
