package com.succulent.user.service;

import com.succulent.user.common.RandomUtil;
import com.succulent.user.common.RespBody;
import com.succulent.user.common.RespCode;
import com.succulent.user.entity.UserBalance;
import com.succulent.user.entity.UserIdentity;
import com.succulent.user.entity.UserInfo;
import com.succulent.user.repository.UserBalanceRepository;
import com.succulent.user.repository.UserIdentityRepository;
import com.succulent.user.repository.UserInfoRepository;
import com.succulent.user.dto.SignUpByPhone;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
/**
 * 实现注册信息输入
 * userIdentity 帐号随机生成，另外和手机绑定，生成随机token
 * userinfo 和id联系起来
 * userbalance初始化设为0
 */
@Service
public class UserSignUpServiceImpl implements UserSignUpService {

    @Resource
    UserIdentityRepository userIdentityRepository;
    @Resource
    UserInfoRepository userInfoRepository;

    @Resource
    UserBalanceRepository userBalanceRepository;

    @Override
    @Transactional
    public Object byPhone(SignUpByPhone dto) {
        UserIdentity userIdentity = new UserIdentity();
        UserInfo userInfo = new UserInfo();
        userIdentity.setId(RandomUtil.genObjectId());
        userIdentity.setPhone(dto.getPhone());
        userIdentity.setPasscode(dto.getPasscode());
        userIdentity.setToken(RandomUtil.genToken());
        userIdentity.setDate((int) System.currentTimeMillis() / 1000);
        userInfo.setUid(userIdentity.getId());
        userIdentityRepository.insert(userIdentity);
        userInfoRepository.insert(userInfo);
        initUser(userIdentity.getId());
        return new RespBody(RespCode.SUCCESS);
        //toString(RespBody);
    }

    @Transactional
    /// 初始化user事件
    private void initUser(String uId) {
        UserBalance userBalance = new UserBalance();
        userBalance.setUid(uId);
        userBalance.setValue(0);
        userBalanceRepository.insert(userBalance);
    }

}
