package com.star.dao;

import com.star.entity.Memory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: MemoryDao
 * @Description: 流年记持久层接口
 * @Author ONESTAR
 * @Date: 2020/10/20 9:10
 * @QQ群：530311074
 * @URL：https://onestar.newstar.net.cn/
 * @Version 1.0
 */
@Mapper
@Repository
public interface MemoryDao {
    // 查询流年记
    List<Memory> listMemory();

    int saveMemory(Memory memory);

    Memory getMemory(Long id);

    int updateMemory(Memory memory);

    void deleteMemory(Long id);
}
