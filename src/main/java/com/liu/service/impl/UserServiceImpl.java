package com.liu.service.impl;

import com.liu.QueryListener;
import com.liu.dto.User;
import com.liu.event.QueryEvent;
import com.liu.mapper.UserMapper;
import com.liu.service.UserInfoService;
import com.liu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.DirectFieldBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;


import static org.springframework.util.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuneng on 2016/12/28.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    @Qualifier("userValidator")
    private Validator validator;
    @Autowired
    private ApplicationEventPublisher publisher;

    private Object lock = new Object();

    public List<User> query(User user) {
        notNull(user, "user can not be null");
        System.out.println("publisher " + publisher.hashCode());
        publisher.publishEvent(new QueryEvent(this).setMessage("query user " + user.toString()));
        return userMapper.select(user);
    }

    public List<String> batchInsert(List<User> users) {
        List<String> result = new ArrayList<String>();
        for (User user : users) {
            if (validator.supports(user.getClass())) {
                Errors errors = new DirectFieldBindingResult(user, String.valueOf(user.hashCode()));
                validator.validate(user, errors);
                if (!errors.hasErrors()) {
                    insert(user);
                    result.add(user.getFirstName() + " " + user.getLastName());
                }
            }
        }
        return result;
    }

    private User insert(User user) {
        synchronized (lock) {
            if (userMapper.getByFirstNameAndLastName(user.getFirstName(), user.getLastName()) == null) {
                userMapper.insert(user);
            }
        }
        return user;
    }

    public int delete(Integer id) {
        return userMapper.delete(new User().setId(id));
    }

    public int update(User user) {
        if (validator.supports(user.getClass())) {
            Errors errors = new DirectFieldBindingResult(user, String.valueOf(user.hashCode()));
            validator.validate(user, errors);
            if (!errors.hasErrors()) {
                return userMapper.update(user);
            }
        }
        return 0;
    }

    public int batchUpdate(List<User> list) {
        int count = 0;
        for (User user : list) {
            count += userMapper.update(user);
        }
        return count;
    }
}
