package org.example.controller;

import org.example.domain.Permission;
import org.example.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService iPermissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = iPermissionService.findAll();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception{
        iPermissionService.save(permission);
        return "redirect:findAll.do";
    }

    @RequestMapping("/deletePermission.do")
    public String deletePermission(@RequestParam(name = "id",required = true)int id) throws Exception{
        iPermissionService.deleteById(id);
        return "redirect:findAll.do";
    }
}
