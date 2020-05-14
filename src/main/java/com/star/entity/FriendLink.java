package com.star.entity;

import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * @Description: 友链实体类
 * @Author: ONESTAR
 * @Date: Created in 9:25 2020/3/26
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
public class FriendLink {

    private Long id;
    private String blogname;
    private String blogaddress;
    private String pictureaddress;
    private Date createTime;

    public FriendLink() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlogname() {
        return blogname;
    }

    public void setBlogname(String blogname) {
        this.blogname = blogname;
    }

    public String getBlogaddress() {
        return blogaddress;
    }

    public void setBlogaddress(String blogaddress) {
        this.blogaddress = blogaddress;
    }

    public String getPictureaddress() {
        return pictureaddress;
    }

    public void setPictureaddress(String pictureaddress) {
        this.pictureaddress = pictureaddress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "FriendLink{" +
                "id=" + id +
                ", blogname='" + blogname + '\'' +
                ", blogaddress='" + blogaddress + '\'' +
                ", pictureaddress='" + pictureaddress + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}