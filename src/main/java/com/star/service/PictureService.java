package com.star.service;

import com.star.entity.Picture;

import java.util.List;

/**
 * @Description: 照片墙业务层接口
 * @Date: Created in 23:30 2020/4/16
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
public interface PictureService {

    //查询照片
    List<Picture> listPicture();

    //添加图片
    int savePicture(Picture picture);

    //根据id查询照片
    Picture getPicture(Long id);

//    编辑修改相册
    int updatePicture(Picture picture);

//    删除照片
    void deletePicture(Long id);

}