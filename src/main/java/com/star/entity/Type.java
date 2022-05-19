package com.star.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 分类实体类
 * @Date: Created in 17:26 2020/5/31
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
public class Type {

    private Long id;
    private String name;
    private List<Blog> blogs = new ArrayList<>();

    public Type() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blogs=" + blogs +
                '}';
    }
}