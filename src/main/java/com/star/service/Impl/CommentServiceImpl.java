package com.star.service.Impl;

import com.star.dao.BlogDao;
import com.star.dao.CommentDao;
import com.star.entity.Comment;
import com.star.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 博客评论业务层接口实现类
 * @Date: Created in 10:23 2020/6/23
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private BlogDao blogDao;

    // 自动导入Java邮件发送实现类
    @Autowired
    private JavaMailSender javaMailSender;

    //存放迭代找出的所有子代的集合
    private List<Comment> tempReplys = new ArrayList<>();

    /**
     * @Description: 查询评论
     * @Auther: ONESTAR
     * @Date: 10:42 2020/6/23
     * @Param: blogId：博客id
     * @Return: 评论消息
     */
    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        //查询出父节点
        List<Comment> comments = commentDao.findByBlogIdParentIdNull(blogId, Long.parseLong("-1"));
        for(Comment comment : comments){
            Long id = comment.getId();
            String parentNickname1 = comment.getNickname();
            List<Comment> childComments = commentDao.findByBlogIdParentIdNotNull(blogId,id);
            //查询出子评论
            combineChildren(blogId, childComments, parentNickname1);
            comment.setReplyComments(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return comments;
    }

    /**
     * @Description: 查询出子评论
     * @Auther: ONESTAR
     * @Date: 10:43 2020/6/23
     * @Param: childComments：所有子评论
     * @Param: parentNickname1：父评论姓名
     * @Return:
     */
    private void combineChildren(Long blogId, List<Comment> childComments, String parentNickname1) {
        //判断是否有一级子评论
        if(childComments.size() > 0){
            //循环找出子评论的id
            for(Comment childComment : childComments){
                String parentNickname = childComment.getNickname();
                childComment.setParentNickname(parentNickname1);
                tempReplys.add(childComment);
                Long childId = childComment.getId();
                //查询出子二级评论
                recursively(blogId, childId, parentNickname);
            }
        }
    }

    /**
     * @Description: 循环迭代找出子集回复
     * @Auther: ONESTAR
     * @Date: 10:44 2020/6/23
     * @Param: chileId:子评论id
     * @Param: parentNickname1:子评论姓名
     * @Return:
     */
    private void recursively(Long blogId, Long childId, String parentNickname1) {
        //根据子一级评论的id找到子二级评论
        List<Comment> replayComments = commentDao.findByBlogIdAndReplayId(blogId,childId);

        if(replayComments.size() > 0){
            for(Comment replayComment : replayComments){
                String parentNickname = replayComment.getNickname();
                replayComment.setParentNickname(parentNickname1);
                Long replayId = replayComment.getId();
                tempReplys.add(replayComment);
                recursively(blogId,replayId,parentNickname);
            }
        }
    }


    //新增评论
    @Override
    public int saveComment(Comment comment,Comment parentComment) {
        comment.setCreateTime(new Date());
        int comments = commentDao.saveComment(comment);
        //文章评论计数
        blogDao.getCommentCountById(comment.getBlogId());

        // 判断是否有父评论，有的话就发送邮件
        if(!StringUtils.isEmpty(parentComment)){
            String parentNickname = parentComment.getNickname();
            String nickName = comment.getNickname();
            String comtent = "亲爱的" + parentNickname + "，您在【ONESTARの客栈】的评论收到了来自" + nickName + "的回复！内容如下：" + "\r\n" + "\r\n" +  comment.getContent();
            String parentEmail = parentComment.getEmail();

            // 发送邮件
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setSubject("ONESTARの客栈评论回复");  //主题
            simpleMailMessage.setText(comtent);   //内容
            simpleMailMessage.setTo(parentEmail); //接收者的邮箱
            simpleMailMessage.setFrom("onestaryxk@163.com");//发送者邮箱
            javaMailSender.send(simpleMailMessage);
        }

        return comments;
    }

    //删除评论
    @Override
    public void deleteComment(Comment comment,Long id) {
        commentDao.deleteComment(id);
        blogDao.getCommentCountById(comment.getBlogId());
    }

    @Override
    public Comment getEmailByParentId(Long parentId) {
        return commentDao.getEmailByParentId(parentId);
    }
}