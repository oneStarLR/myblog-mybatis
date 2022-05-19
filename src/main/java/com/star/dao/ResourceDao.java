package com.star.dao;

import com.star.entity.Picture;
import com.star.entity.Resources;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 资源库持久层接口
 * @Date: Created in 18:05 2020/8/2
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Mapper
@Repository
public interface ResourceDao {

//    新增资源
    int saveResource(Resources resources);

//    查询资源列表
    List<Resources> listResources();

//    根据ID查询资源
    Resources getResource(Long id);

//    编辑资源
    int updateResource(Resources resources);

//    根据ID删除资源
    void deleteResource(Long id);

//    是否发布
    void is_published(Long id);

//    改变发布状态
    int changePublished(@Param("published") boolean published,@Param("id") Long id);

    // 查询学习资源
    List<Resources> getStudyResource(String studyResource);

    // 查询图片资源
    List<Resources> getPictureResource(String pictureResource);

    // 查询办公资源
    List<Resources> getOfficeResource(String officeResource);

    // 查询娱乐资源
    List<Resources> getRecreationResource(String recrearionResource);

    // 查询设计资源
    List<Resources> getDesignResource(String desognResource);

    // 查询搜索资源
    List<Resources> getSearchResource(String searchResource);

    // 查询工具资源
    List<Resources> getToolResource(String toolResource);

    Integer getStudyResourceTotle(String studyResource);

    Integer getPictureResourceTotle(String pictureResource);

    Integer getOfficeResourceTotle(String officeResource);

    Integer getRecreationResourceTotle(String recreationResource);

    Integer getDesignResourceTotle(String designResource);

    Integer getSearchResourceTotle(String searchResource);

    Integer getToolResourceTotle(String toolResource);
}