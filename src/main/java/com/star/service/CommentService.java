package com.star.service;

import com.star.entity.Comment;

import java.util.List;

/**
 * @Description: 博客评论业务层接口
 * @Author: ONESTAR
 * @Date: Created in 13:26 2020/4/5
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    int saveComment(Comment comment);

//    查询子评论
//    List<Comment> getChildComment(Long blogId,Long id);

    //删除评论
    void deleteComment(Comment comment,Long id);

}