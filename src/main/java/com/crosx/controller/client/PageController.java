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
        List<TUserEntity> userList = userRepository.findAll();
        for (TUserEntity user : userList) {
            if (user.getUserPhone().equals(userPhone)) {
                String pwd = user.getUserPwd();
                if (pwd.equals(userPwd)) {
                    mav.setViewName("user/login_success");
                } else {
                    mav.setViewName("user/login_error");
                }
            }
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
        List<TUserEntity> userList = userRepository.findAll();
        for (TUserEntity userEntity : userList) {
            if (userEntity.getUserPhone().equals(user.getUserPhone())) {
                System.out.println("手机号已注册");
                return "user/register";
            } else if (userEntity.getNickName().equals(user.getNickName())) {
                System.out.println("昵称已存在");
                return "user/register";
            } else {
                userRepository.saveAndFlush(user);
                return "redirect:/user/login";
            }
        }
        return "user/register";

    }

}
