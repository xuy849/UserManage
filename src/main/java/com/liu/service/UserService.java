package com.liu.service;

import com.liu.dto.User;

import java.util.List;
import java.util.Map;

/**
 * Created by liuneng on 2016/12/28.
 */
public interface UserService {
    List<User> query(User user);
    List<String> batchInsert(List<User> users);
    int delete(Integer id);
    int update(User user);
    int batchUpdate(List<User> list);
}
