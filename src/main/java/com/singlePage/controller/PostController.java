package com.singlePage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PostController {
    @RequestMapping(value = "/dashboard/kangPage", method = RequestMethod.GET)
    public ModelAndView kangPage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("dashboard/kangPage");
        return mav;
    }
}

