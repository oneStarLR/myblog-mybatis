package com.star.controller;

import com.star.annotation.AccessLimit;
import com.star.entity.Comment;
import com.star.entity.Message;
import com.star.entity.User;
import com.star.queryvo.DetailedBlog;
import com.star.service.BlogService;
import com.star.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description: 评论控制器
 * @Date: Created in 10:25 2020/6/23
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @Value("${comment.avatar}")
    private String avatar;

    //查询评论列表
    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model) {
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("comments", comments);
        return "blog :: commentList";
    }

    //新增评论
    @PostMapping("/comments")
    @AccessLimit(seconds = 15, maxCount = 3) //15秒内 允许请求3次
    public String post(Comment comment, HttpSession session, Model model) {
        Long blogId = comment.getBlogId();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        } else {
            //设置头像
            comment.setAvatar(avatar);
        }
        Long parentId = comment.getParentComment().getId();
        Comment parentComment = null;
        if (comment.getParentComment().getId() != null) {
            comment.setParentCommentId(parentId);

            // 根据父评论id查询留言信息
            parentComment = commentService.getEmailByParentId(parentId);
        }
        commentService.saveComment(comment,parentComment);
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("comments", comments);
        return "blog :: commentList";
    }

    //删除评论
    @GetMapping("/comment/{blogId}/{id}/delete")
    public String delete(@PathVariable Long blogId, @PathVariable Long id, Comment comment, HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        if(user != null) {
            commentService.deleteComment(comment,id);
        }
        DetailedBlog detailedBlog = blogService.getDetailedBlog(blogId);
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("blog", detailedBlog);
        model.addAttribute("comments", comments);
        return "blog";
    }

}
