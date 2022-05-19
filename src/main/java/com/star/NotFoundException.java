package com.star;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Description: 自定义异常类
 * @Date: Created in 21:36 2020/5/21
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}