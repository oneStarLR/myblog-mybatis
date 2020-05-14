package com.star.queryvo;

/**
 * @Description: 推荐博客数据实体类
 * @Author: ONESTAR
 * @Date: Created in 10:45 2020/4/3
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
public class RecommendBlog {

    private Long id;
    private String title;
    private String firstPicture;
    private boolean recommend;

    public RecommendBlog() {
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

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    @Override
    public String toString() {
        return "RecommendBlog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", recommend=" + recommend +
                '}';
    }
}