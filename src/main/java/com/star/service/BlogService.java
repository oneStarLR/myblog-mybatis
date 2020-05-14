package com.star.service;

import com.star.entity.Blog;
import com.star.queryvo.*;

import java.util.List;

/**
 * @Description: 博客列表业务层接口
 * @Author: ONESTAR
 * @Date: Created in 23:31 2020/3/30
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
public interface BlogService {

    ShowBlog getBlogById(Long id);

    List<BlogQuery> getAllBlog();

    int saveBlog(Blog blog);

    int updateBlog(ShowBlog showBlog);

    void deleteBlog(Long id);

    List<BlogQuery> getBlogBySearch(SearchBlog searchBlog);

    List<FirstPageBlog> getAllFirstPageBlog();

    List<RecommendBlog> getRecommendedBlog();

//    List<FirstPageBlog> getNewBlog();

    List<FirstPageBlog> getSearchBlog(String query);

    DetailedBlog getDetailedBlog(Long id);

    //根据TypeId获取博客列表，在分类页进行的操作
    List<FirstPageBlog> getByTypeId(Long typeId);

    Integer getBlogTotal();

    Integer getBlogViewTotal();

    Integer getBlogCommentTotal();

    Integer getBlogMessageTotal();

}