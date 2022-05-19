package com.star.entity;

import java.util.Date;

/**
 * @ClassName: Menory
 * @Description: 流年记实体类
 * @Author ONESTAR
 * @Date: 2020/10/13 22:37
 * @QQ群：530311074
 * @URL：https://onestar.newstar.net.cn/
 * @Version 1.0
 */
public class Memory {

    private Long id;
    private Date createTime;
    private String pictureAddress;
    private String memory;

    public Memory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", pictureAddress='" + pictureAddress + '\'' +
                ", memory='" + memory + '\'' +
                '}';
    }
}
