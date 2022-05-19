package com.star.entity;

import java.io.Serializable;

/**
 * @Description: 相册实体类
 * @Date: Created in 12:02 2020/6/1
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
public class Picture implements Serializable {

    private Long id;
    private String picturename;
    private String picturetime;
    private String pictureaddress;
    private String picturedescription;

    public Picture() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicturename() {
        return picturename;
    }

    public void setPicturename(String picturename) {
        this.picturename = picturename;
    }

    public String getPicturetime() {
        return picturetime;
    }

    public void setPicturetime(String picturetime) {
        this.picturetime = picturetime;
    }

    public String getPictureaddress() {
        return pictureaddress;
    }

    public void setPictureaddress(String pictureaddress) {
        this.pictureaddress = pictureaddress;
    }

    public String getPicturedescription() {
        return picturedescription;
    }

    public void setPicturedescription(String picturedescription) {
        this.picturedescription = picturedescription;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", picturename='" + picturename + '\'' +
                ", picturetime='" + picturetime + '\'' +
                ", pictureaddress='" + pictureaddress + '\'' +
                ", picturedescription='" + picturedescription + '\'' +
                '}';
    }
}