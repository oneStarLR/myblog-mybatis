package com.star.queryvo;

import com.star.entity.Type;

import java.util.Date;

/**
 * @Description: 显示数据实体类
 * @Author: ONESTAR
 * @Date: Created in 15:20 2020/3/31
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
public class BlogQuery {

    private Long id;
    private String title;
    private Date updateTime;
    private Boolean recommend;
    private Boolean published;
    private Long typeId;
    private Type type;

    public BlogQuery() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BlogQuery{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", updateTime=" + updateTime +
                ", recommend=" + recommend +
                ", published=" + published +
                ", typeId=" + typeId +
                ", type=" + type +
                '}';
    }
}