package com.harvey.security.boot.controller;


import com.harvey.security.boot.Constant;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * TODO
 *
 * @author Harvey Blocks
 * @version 1.0
 * @className MyController
 * @date 2023-12-15 17:31
 */
@RestController
public class UserController {

    @PostMapping(value = "/login-judge")
    public ModelAndView loginJudge() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/login-success");
        return modelAndView;
    }

    /**
     * @return 当前用户的用户信息
     */
    private String getUsername() {
        String username = "";

        // 获取当前认证成功的用户信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 用户身份
        Object principal = authentication.getPrincipal();

        if (principal == null) {
            username = "游客";
        } else if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            username = userDetails.getUsername();
        } else {
            username = principal.toString();// 看需求
        }

        return username;
    }

    @RequestMapping(value = "/login-success", produces = Constant.HTML_PRODUCES)
    public String show(HttpServletRequest request) {
        return getUsername() + " 登录成功<br>" +
                "<a href=\"" + request.getContextPath() + "/logout-view\">登出</a><br>" +
                "<a href=\"" + request.getContextPath() + "/resource/r0\">资源0</a><br>" +
                "<a href=\"" + request.getContextPath() + "/resource/r1\">资源1</a><br>";
    }


    @GetMapping(value = "/logout-view", produces = Constant.HTML_PRODUCES)
    public String logout(HttpSession session) {
        session.invalidate();//让Session失效
        return "已登出<br>" +
                "<a href=\"index\">返回主页面</a><br>";
    }


}

