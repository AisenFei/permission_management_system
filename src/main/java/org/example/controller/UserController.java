package org.example.controller;

import org.example.domain.Role;
import org.example.domain.UserInfo;
import org.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/findById.do")
    public ModelAndView findById(int id) throws Exception{
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("userInfo",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception{
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> list = userService.findAll();
        mv.addObject("userList",list);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(int id)throws Exception{
        ModelAndView mv = new ModelAndView();
        //1.根据用户id查询用户
        UserInfo userInfo = userService.findById(id);
        //2.根据用户id查询可以添加的角色
        List<Role> otherRoles = userService.findOtherRoles(id);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) int userId,@RequestParam(name = "ids",required = true) int[] roleIds)throws Exception{
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }
}
