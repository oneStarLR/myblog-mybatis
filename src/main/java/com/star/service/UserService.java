package com.star.service;

import com.star.entity.User;

/**
 * @Description: 用户业务层接口
 * @Author: ONESTAR
 * @Date: Created in 10:59 2020/3/26
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
public interface UserService {

//    核对用户名和密码
    User checkUser(String username, String password);

}