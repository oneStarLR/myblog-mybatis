package com.star.service.Impl;

import com.star.dao.TypeDao;
import com.star.entity.Type;
import com.star.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 分类业务层接口实现类
 * @Date: Created in 13:32 2020/6/2
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Transactional
    @Override
    public int saveType(Type type) {
        return typeDao.saveType(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeDao.getType(id);
    }

    @Transactional
    @Override
    public List<Type> getAllType() {
        return typeDao.getAllType();
    }

    @Override
    public Type getTypeByName(String name) {
        return typeDao.getTypeByName(name);
    }

    @Transactional
    @Override
    public int updateType(Type type) {
        return typeDao.updateType(type);
    }

    @Transactional
    @Override
    public void deleteType(Long id) {
        typeDao.deleteType(id);
    }

    @Transactional
    @Override
    public List<Type> getAllTypeAndBlog() {
        return typeDao.getAllTypeAndBlog();
    }
}