package org.example.controller;

import org.example.domain.Permission;
import org.example.domain.Role;
import org.example.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService iRoleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = iRoleService.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Role role) throws Exception{
        iRoleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) int id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Role role = iRoleService.findById(id);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }

    @RequestMapping("/deleteRole.do")
    public String deleteRole(@RequestParam(name = "id",required = true)int id) throws Exception{
        iRoleService.deleteRoleById(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(int id)throws Exception{
        ModelAndView mv = new ModelAndView();
        //1.根据role_id查询role
        Role role = iRoleService.findById(id);
        //2.根据roleId查询可以添加的权限
        List<Permission> otherPermissions = iRoleService.findOtherPermissions(id);
        mv.addObject("role",role);
        mv.addObject("permissionList",otherPermissions);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true)int roleId,@RequestParam(name = "ids",required = true)int[] pIds)throws Exception{
        iRoleService.addPermissionToRole(roleId,pIds);
        return "redirect:findAll.do";
    }
}
