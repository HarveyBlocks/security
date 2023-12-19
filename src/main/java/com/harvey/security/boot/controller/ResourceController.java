package com.harvey.security.boot.controller;

import com.harvey.security.boot.Constant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * TODO
 *
 * @author Harvey Blocks
 * @version 1.0
 * @className ResourceController
 * @date 2023-12-15 21:02
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {
    @GetMapping(value = "/r0",produces = Constant.TEXT_PRODUCES)
    public String resource0(){
        return "好康的\n";
    }
    @GetMapping(value = "/r1",produces = Constant.TEXT_PRODUCES)
    public String resource1(){
        return "学习资料\n";
    }
    @GetMapping(value = "/r2",produces = Constant.TEXT_PRODUCES)
    public ModelAndView resource2(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.html");
        return modelAndView;
    }
}
