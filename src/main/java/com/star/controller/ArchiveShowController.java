package com.star.controller;

import com.star.queryvo.BlogQuery;
import com.star.service.BlogService;
import com.star.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Description: 时间轴页面显示控制器
 * @Date: Created in 17:40 2020/6/27
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Controller
public class ArchiveShowController {

    @Autowired
    private MemoryService memoryService;

    @GetMapping("/archives")
    public String archive(Model model){
        model.addAttribute("memorys",  memoryService.listMemory());
        return "archives";
    }

}