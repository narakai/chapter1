package com.clem.service.impl;

import com.clem.dao.UserMapper;
import com.clem.domain.User;
import com.clem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by laileon on 2017/3/13.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    @Transactional
    public User finaUserByName(String name) {
        return userMapper.selectByName(name);
    }
}
