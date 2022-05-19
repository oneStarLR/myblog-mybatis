package com.star.service;

import com.star.entity.Blog;
import com.star.queryvo.*;

import java.util.List;

/**
 * @Description: 博客列表业务层接口
 * @Date: Created in 23:46 2020/6/2
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
public interface BlogService {

    //保存新增博客
    int saveBlog(Blog blog);

    //查询文章管理列表
    List<BlogQuery> getAllBlog();

    //删除博客
    void deleteBlog(Long id);

    //查询编辑修改的文章
    ShowBlog getBlogById(Long id);

    //编辑修改文章
    int updateBlog(ShowBlog showBlog);

    //搜索博客管理列表
    List<BlogQuery> getBlogBySearch(SearchBlog searchBlog);


    //查询首页最新博客列表信息
    List<FirstPageBlog> getAllFirstPageBlog();

    //查询首页最新推荐信息
    List<RecommendBlog> getRecommendedBlog();

    //搜索博客列表
    List<FirstPageBlog> getSearchBlog(String query);

    //统计博客总数
    Integer getBlogTotal();

    //统计访问总数
    Integer getBlogViewTotal();

    //统计评论总数
    Integer getBlogCommentTotal();

    //统计留言总数
    Integer getBlogMessageTotal();

    //查询博客详情
    DetailedBlog getDetailedBlog(Long id);

    //根据TypeId查询博客列表，显示在分类页面
    List<FirstPageBlog> getByTypeId(Long typeId);

    //查询最新评论
    List<NewComment> getNewComment();
}