package org.example.controller;

import com.github.pagehelper.PageInfo;
import org.example.domain.Orders;
import org.example.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService iOrdersService;

    //为分页的查询全部操作
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception{
//        List<Orders> all = iOrdersService.findAll();
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("orders-list");
//        mv.addObject("ordersList",all);
//        return mv;
//    }

    //分页的查询全部操作
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page,
                                @RequestParam(name = "size",required = true,defaultValue = "4") int size) throws Exception{
        List<Orders> all = iOrdersService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(all);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders-page-list");
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }

    //通过id查询
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) int orders_id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders = iOrdersService.findById(orders_id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
