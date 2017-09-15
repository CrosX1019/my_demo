package com.crosx.controller.client;

import com.crosx.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController extends BaseController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView pageLogin() throws Exception {
        ModelAndView mav = new ModelAndView("user/login");
        mav.setViewName("user/login");
        return mav;
    }

//    @RequestMapping(value = "login.action")
//    public ModelAndView login(String userName,String password){
//        if (userName.equals("admin")){
//            System.out.println("登录成功");
//
//        }
//
//    }

}
