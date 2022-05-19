package com.star.service;

import com.star.entity.Picture;
import com.star.entity.Resources;

import java.util.List;

/**
 * @Description: 资源库业务层接口
 * @Date: Created in 17:59 2020/8/2
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
public interface ResourceService {

    int savePicture(Resources resources);

    List<Resources> listResources();

    Resources getResource(Long id);

    int updateResource(Resources resources);

    void deleteResource(Long id);

    void is_published(Long id);


    int changePublished(boolean flage,Long id);


    List<Resources> getStudyResource(String studyResource);

    List<Resources> getPictureResource(String pictureResource);

    List<Resources> getOfficeResource(String officeResource);

    List<Resources> getRecreationResource(String recreationResource);

    List<Resources> getDesignResource(String designResource);

    List<Resources> getSearchResource(String searchResource);

    List<Resources> getToolResource(String toolResource);

    Integer getStudyResourceTotle(String studyResource);

    Integer getPictureResourceTotle(String pictureResource);

    Integer getOfficeResourceTotle(String officeResource);

    Integer getRecreationResourceTotle(String recreationResource);

    Integer getDesignResourceTotle(String designResource);

    Integer getSearchResourceTotle(String searchResource);

    Integer getToolResourceTotle(String toolResource);
}