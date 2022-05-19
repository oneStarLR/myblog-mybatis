package com.star.annotation;


import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AccessLimit {
    int seconds();
    int maxCount();
    boolean needLogin()default true;
}
