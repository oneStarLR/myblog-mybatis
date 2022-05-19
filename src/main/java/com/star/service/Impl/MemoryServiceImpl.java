package com.star.service.Impl;

import com.star.dao.MemoryDao;
import com.star.entity.Memory;
import com.star.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: MemoryServiceImpl
 * @Description: 流年记业务层接口实现类
 * @Author ONESTAR
 * @Date: 2020/10/20 9:06
 * @QQ群：530311074
 * @URL：https://onestar.newstar.net.cn/
 * @Version 1.0
 */
@Service
public class MemoryServiceImpl implements MemoryService {

    @Autowired
    private MemoryDao memoryDao;

    @Override
    @Cacheable(value = "memoryList",key = "'memory'")       // redis缓存
    public List<Memory> listMemory() {
        return memoryDao.listMemory();
    }

    @Override
    public int saveMemory(Memory memory) {
        return memoryDao.saveMemory(memory);
    }

    @Override
    public Memory getMemory(Long id) {
        return memoryDao.getMemory(id);
    }

    @Override
    public int updateMemory(Memory memory) {
        return memoryDao.updateMemory(memory);
    }

    @Override
    public void deleteMemory(Long id) {
        memoryDao.deleteMemory(id);
    }
}
