package com.atguigu.shiro.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.shiro.service.ShiroService;

@Controller
@RequestMapping("/shiro")
public class ShiroController {

    @Autowired
    private ShiroService shiroService;

    @RequestMapping("/testShiroAnnotation")
    public String testShiroAnnotation(HttpSession session) {
        session.setAttribute("key", "value12345");
        shiroService.testMethod();
        return "redirect:/list.jsp";
    }

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            //把用户名和密码封装为UsernamePasswordToken对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            //记住我
            token.setRememberMe(true);
            try {
                System.out.println("UsernamePasswordToken：" + token.hashCode());
                //执行登录
                currentUser.login(token);
            }
            //所有认证时异常的父类
            catch (AuthenticationException ae) {
                System.out.println("登录失败：" + ae.getMessage());
            }
        }
        return "redirect:/list.jsp";
    }

}
