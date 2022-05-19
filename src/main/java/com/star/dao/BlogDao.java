package com.star.dao;

import com.star.entity.Blog;
import com.star.queryvo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 博客管理持久层接口
 * @Date: Created in 23:45 2020/6/2
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Mapper
@Repository
public interface BlogDao {

    //保存新增博客
    int saveBlog(Blog blog);

    //查询文章管理列表
    List<BlogQuery> getAllBlogQuery();

    //删除博客
    void deleteBlog(Long id);

    //编辑博客
    int updateBlog(ShowBlog showBlog);

    //查询编辑修改的文章
    ShowBlog getBlogById(Long id);

    //搜索博客管理列表
    List<BlogQuery> searchByTitleAndType(SearchBlog searchBlog);


    //查询首页最新博客列表信息
    List<FirstPageBlog> getFirstPageBlog();

    //查询首页最新推荐信息
    List<RecommendBlog> getAllRecommendBlog();

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

    //文章访问更新
    int updateViews(Long id);

    //根据博客id查询出评论数量
    int getCommentCountById(Long id);


    //根据TypeId查询博客列表，显示在分类页面
    List<FirstPageBlog> getByTypeId(Long typeId);

    //查询最新评论
    List<NewComment> getNewComment();
}