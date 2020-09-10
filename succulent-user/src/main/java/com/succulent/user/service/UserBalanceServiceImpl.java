package com.succulent.user.service;

import com.succulent.user.common.RespBody;
import com.succulent.user.common.RespCode;
import com.succulent.user.entity.UserBalance;
import com.succulent.user.repository.UserBalanceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserBalanceServiceImpl implements UserBalanceService {

    @Resource
    UserBalanceRepository userBalanceRepository;

    @Override
    public Object query(UserBalance userBalance) {
        return new RespBody(RespCode.SUCCESS, userBalanceRepository.findByUId(userBalance));
    }
    @Override
    @Transactional
    public Object addValueByUId(UserBalance userBalance) {
        //userBalance.setAddedStat(userBalance.getStat());
        return new RespBody(RespCode.SUCCESS, userBalanceRepository.addValueByUId(userBalance));
    }

    @Override
    @Transactional
    public Object subtractValueByUId(UserBalance userBalance) {
        //userBalance.setSubtractedStat(userBalance.getStat());
        return new RespBody(RespCode.SUCCESS, userBalanceRepository.subtractValueByUId(userBalance));
    }
}
