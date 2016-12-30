package com.liu.service;

import com.liu.dto.UserInfo;

/**
 * Created by liuneng on 2016/12/28.
 */
public interface UserInfoService {
    UserInfo insert(UserInfo userInfo);
    int update(UserInfo userInfo);
    int delete(int id);
}
