package com.star.queryvo;

/**
 * @Description: 最新评论实体类
 * @Date: Created in 19:45 2020/8/19
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
public class NewComment {

    private Long id;
    private Long blogId;
    private String title;
    private String content;

    public NewComment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "NewComment{" +
                "id=" + id +
                ", blogId=" + blogId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}