package com.star.service;

import com.star.entity.Memory;

import java.util.List;

/**
 * @ClassName: MemoryService
 * @Description: 流年记业务层接口
 * @Author ONESTAR
 * @Date: 2020/10/20 9:06
 * @QQ群：530311074
 * @URL：https://onestar.newstar.net.cn/
 * @Version 1.0
 */
public interface MemoryService {
    List<Memory> listMemory();

    int saveMemory(Memory memory);

    Memory getMemory(Long id);

    int updateMemory(Memory memory);

    void deleteMemory(Long id);
}
