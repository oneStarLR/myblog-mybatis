package com.star.service.Impl;

import com.star.dao.ResourceDao;
import com.star.entity.Picture;
import com.star.entity.Resources;
import com.star.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 资源库业务层接口实现类
 * @Date: Created in 18:00 2020/8/2
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public int savePicture(Resources resources) {
        return resourceDao.saveResource(resources);
    }

    @Override
    public List<Resources> listResources() {
        return resourceDao.listResources();
    }

    @Override
    public Resources getResource(Long id) {
        return resourceDao.getResource(id);
    }

    @Override
    public int updateResource(Resources resources) {
        return resourceDao.updateResource(resources);
    }

    @Override
    public void deleteResource(Long id) {
        resourceDao.deleteResource(id);
    }

    @Override
    public void is_published(Long id) {
        resourceDao.is_published(id);
    }

    @Override
    public int changePublished(boolean flage,Long id) {
        return resourceDao.changePublished(flage,id);
    }

    @Override
    @Cacheable(value = "studyResource",key = "'studyResourceList'")      // redis缓存
    public List<Resources> getStudyResource(String studyResource) {
        return resourceDao.getStudyResource(studyResource);
    }

    @Override
    @Cacheable(value = "pictureResource",key = "'pictureResourceList'")      // redis缓存
    public List<Resources> getPictureResource(String pictureResource) {
        return resourceDao.getPictureResource(pictureResource);
    }

    @Override
    @Cacheable(value = "officeResource",key = "'officeResourceList'")      // redis缓存
    public List<Resources> getOfficeResource(String officeResource) {
        return resourceDao.getOfficeResource(officeResource);
    }

    @Override
    @Cacheable(value = "recreationResource",key = "'recreationResourceList'")      // redis缓存
    public List<Resources> getRecreationResource(String recreationResource) {
        return resourceDao.getRecreationResource(recreationResource);
    }

    @Override
    @Cacheable(value = "designResource",key = "'designResourceList'")      // redis缓存
    public List<Resources> getDesignResource(String designResource) {
        return resourceDao.getDesignResource(designResource);
    }

    @Override
    @Cacheable(value = "searchResource",key = "'searchResourceList'")      // redis缓存
    public List<Resources> getSearchResource(String searchResource) {
        return resourceDao.getSearchResource(searchResource);
    }

    @Override
    @Cacheable(value = "toolResource",key = "'toolResourceList'")      // redis缓存
    public List<Resources> getToolResource(String toolResource) {
        return resourceDao.getToolResource(toolResource);
    }

    @Override
    public Integer getStudyResourceTotle(String studyResource) {
        return resourceDao.getStudyResourceTotle(studyResource);
    }

    @Override
    public Integer getPictureResourceTotle(String pictureResource) {
        return resourceDao.getPictureResourceTotle(pictureResource);
    }

    @Override
    public Integer getOfficeResourceTotle(String officeResource) {
        return resourceDao.getOfficeResourceTotle(officeResource);
    }

    @Override
    public Integer getRecreationResourceTotle(String recreationResource) {
        return resourceDao.getRecreationResourceTotle(recreationResource);
    }

    @Override
    public Integer getDesignResourceTotle(String designResource) {
        return resourceDao.getDesignResourceTotle(designResource);
    }

    @Override
    public Integer getSearchResourceTotle(String searchResource) {
        return resourceDao.getSearchResourceTotle(searchResource);
    }

    @Override
    public Integer getToolResourceTotle(String toolResource) {
        return resourceDao.getToolResourceTotle(toolResource);
    }


}