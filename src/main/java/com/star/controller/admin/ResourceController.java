package com.star.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.star.entity.Picture;
import com.star.entity.Resources;
import com.star.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * @Description: 资源后台管理控制器
 * @Date: Created in 17:55 2020/8/2
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Controller
@RequestMapping("/admin")
public class ResourceController {

    boolean flage;

    @Autowired
    private ResourceService resourceService;


    //    查询照片列表
    @GetMapping("/resources")
    public String pictures(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Resources> listResources = resourceService.listResources();
        PageInfo<Resources> pageInfo = new PageInfo<Resources>(listResources);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/resources";
    }

    //    跳转新增页面
    @GetMapping("/resources/input")
    public String input(Model model) {
        model.addAttribute("resource", new Resources());
        return "admin/resources-input";
    }


    //    资源新增
    @PostMapping("/resources")
    public String post(@Valid Resources resources, BindingResult result, RedirectAttributes attributes){
        resources.setPublished(true);
        if(result.hasErrors()){
            return "admin/resources-input";
        }

        int P = resourceService.savePicture(resources);
        if (P == 0 ) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/resources";
    }

    //    跳转照片编辑页面
    @GetMapping("/resources/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("resource", resourceService.getResource(id));
        return "admin/resources-input";
    }

    //    编辑相册
    @PostMapping("/resources/{id}")
    public String editPost(@Valid Resources resources, RedirectAttributes attributes) {

        int P = resourceService.updateResource(resources);
        if (P == 0 ) {
            attributes.addFlashAttribute("message", "编辑失败");
        } else {
            attributes.addFlashAttribute("message", "编辑成功");
        }
        return "redirect:/admin/resources";
    }

    //    删除资源
    @GetMapping("/resources/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        resourceService.deleteResource(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/resources";
    }

    /**
     * @description 发布资源
     * @author ONESTAR
     * @date 2020/12/1 9:07
     * @param id
     * @param attributes
     * @throws
     * @return java.lang.String
     */
    @GetMapping("/resources/{id}/public")
    public String is_published(@PathVariable Long id, RedirectAttributes attributes){

        Resources resources = resourceService.getResource(id);

        flage = resources.isPublished();
        if(!flage){
            resourceService.changePublished(true,id);
            attributes.addFlashAttribute("message", "成功发布");
            flage = !flage;
        }else{
            resourceService.changePublished(false,id);
            attributes.addFlashAttribute("message", "取消发布");
            flage = !flage;
        }

        return "redirect:/admin/resources";
    }


}