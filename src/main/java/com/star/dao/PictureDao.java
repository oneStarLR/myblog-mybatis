package com.star.dao;

import com.star.entity.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Date: Created in 11:42 2020/6/15
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Mapper
@Repository
public interface PictureDao {

    //查询照片
    List<Picture> listPicture();

    //添加图片
    int savePicture(Picture picture);

    //根据id查询照片
    Picture getPicture(Long id);

    //编辑修改相册
    int updatePicture(Picture picture);

    //删除照片
    int deletePicture(Long id);

}