package com.star.entity;

import java.util.Date;

/**
 * @Description: 资源库实体类
 * @Date: Created in 14:33 2020/8/2
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
public class Resources {

    private Long id;
    private String resourceName;
    private String firstType;
    private String secondType;
    private String pictureAddress;
    private String resourceAddress;
    private String resourceDescription;
    private Date createTime;
    private Integer sort;
    private boolean published;

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public Resources() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getFirstType() {
        return firstType;
    }

    public void setFirstType(String firstType) {
        this.firstType = firstType;
    }

    public String getSecondType() {
        return secondType;
    }

    public void setSecondType(String secondType) {
        this.secondType = secondType;
    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }

    public String getResourceAddress() {
        return resourceAddress;
    }

    public void setResourceAddress(String resourceAddress) {
        this.resourceAddress = resourceAddress;
    }

    public String getResourceDescription() {
        return resourceDescription;
    }

    public void setResourceDescription(String resourceDescription) {
        this.resourceDescription = resourceDescription;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Resources{" +
                "id=" + id +
                ", resourceName='" + resourceName + '\'' +
                ", firstType='" + firstType + '\'' +
                ", secondType='" + secondType + '\'' +
                ", pictureAddress='" + pictureAddress + '\'' +
                ", resourceAddress='" + resourceAddress + '\'' +
                ", resourceDescription='" + resourceDescription + '\'' +
                ", createTime=" + createTime +
                ", sort=" + sort +
                ", published=" + published +
                '}';
    }
}