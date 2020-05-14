package com.star.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.star.entity.FriendLink;
import com.star.service.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @Description: 友链后台管理控制器
 * @Date: Created in 14:01 2020/4/16
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Controller
@RequestMapping("/admin")
public class FriendController {

    @Autowired
    private FriendLinkService friendLinkService;

//    查询所有友链
    @GetMapping("/friendlinks")
    public String friend(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<FriendLink> listFriendLink = friendLinkService.listFriendLink();
        PageInfo<FriendLink> pageInfo = new PageInfo<FriendLink>(listFriendLink);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/friendlinks";
    }

//    跳转友链新增页面
    @GetMapping("/friendlinks/input")
    public String input(Model model) {
        model.addAttribute("friendlink", new FriendLink());
        return "admin/friendlinks-input";
    }

//    友链新增
    @PostMapping("/friendlinks")
    public String post(@Valid FriendLink friendLink, BindingResult result, RedirectAttributes attributes){

        FriendLink type1 = friendLinkService.getFriendLinkByBlogaddress(friendLink.getBlogaddress());
        if (type1 != null) {
            attributes.addFlashAttribute("message", "不能添加相同的网址");
            return "redirect:/admin/friendlinks/input";
        }

        if(result.hasErrors()){
            return "admin/friendlinks-input";
        }
        friendLink.setCreateTime(new Date());
        int F = friendLinkService.saveFriendLink(friendLink);
        if (F == 0 ) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/friendlinks";
    }

//    跳转友链修改页面
    @GetMapping("/friendlinks/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("friendlink", friendLinkService.getFriendLink(id));
        return "admin/friendlinks-input";
    }

//    编辑修改友链
    @PostMapping("/friendlinks/{id}")
    public String editPost(@Valid FriendLink friendLink, RedirectAttributes attributes) {
        int t = friendLinkService.updateFriendLink(friendLink);
        if (t == 0 ) {
            attributes.addFlashAttribute("message", "编辑失败");
        } else {
            attributes.addFlashAttribute("message", "编辑成功");
        }
        return "redirect:/admin/friendlinks";
    }

//    删除友链
    @GetMapping("/friendlinks/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        friendLinkService.deleteFriendLink(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/friendlinks";
    }

}