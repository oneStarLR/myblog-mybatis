package com.star.queryvo;

/**
 * @Description: 搜索博客管理列表
 * @Date: Created in 14:16 2020/6/8
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
public class SearchBlog {

    private String title;
    private Long typeId;

    public SearchBlog() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "SearchBlog{" +
                "title='" + title + '\'' +
                ", typeId=" + typeId +
                '}';
    }
}