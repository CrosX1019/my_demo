package com.crosx.controller.client;

import com.crosx.controller.BaseController;
import com.crosx.model.TUserEntity;
import com.crosx.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PageController extends BaseController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public ModelAndView pageLogin() throws Exception {
        ModelAndView mav = new ModelAndView("user/login");
        return mav;
    }

    @RequestMapping(value = "/user/login.action")
    public ModelAndView login(String userPhone, String userPwd) {
        ModelAndView mav = new ModelAndView();
        if (userPhone.equals("admin") && userPwd.equals("123456")) {
            System.out.println("登录成功");
            mav.setViewName("user/login_success");
        } else {
            mav.setViewName("user/login_error");
        }
        return mav;
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public ModelAndView pageRegister() throws Exception {
        ModelAndView mav = new ModelAndView("user/register");
        return mav;
    }

    @RequestMapping(value = "/user/register.action", method = RequestMethod.POST)
    public String register(@ModelAttribute("t_user") TUserEntity user) {
        userRepository.saveAndFlush(user);
        return "redirect:/user/login";
    }

}
