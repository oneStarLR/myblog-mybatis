package com.star.service.Impl;

import com.star.dao.UserDao;
import com.star.entity.User;
import com.star.service.UserService;
import com.star.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户业务层接口实现类
 * @Author: ONESTAR
 * @Date: Created in 11:04 2020/3/26
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}