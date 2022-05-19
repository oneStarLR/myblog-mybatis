package com.star.service.Impl;

import com.star.dao.UserDao;
import com.star.entity.User;
import com.star.service.UserService;
import com.star.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户业务层接口实现类
 * @Date: Created in 23:01 2020/5/26
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * @Description:
     * @Auther: ONESTAR
     * @Date: 21:25 2020/5/27
     * @Param: username:用户名；password:密码
     * @Return: 返回用户对象
     */
    @Override
    public User checkUser(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}