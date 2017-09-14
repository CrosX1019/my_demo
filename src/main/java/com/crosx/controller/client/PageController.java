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

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView pageMain() throws Exception {
        ModelAndView mav = new ModelAndView("/main");
        mav.setViewName("/main");
        return mav;
    }

}
