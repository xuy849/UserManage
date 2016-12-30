package com.liu.service.impl;

import com.liu.dto.UserInfo;
import com.liu.mapper.UserInfoMapper;
import com.liu.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liuneng on 2016/12/28.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo insert(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }

    public int update(UserInfo userInfo) {
        return userInfoMapper.update(userInfo);
    }

    public int delete(int id) {
        return userInfoMapper.delete(new UserInfo().setUserId(id));
    }
}
