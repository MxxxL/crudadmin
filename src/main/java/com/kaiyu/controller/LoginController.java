package com.kaiyu.controller;

import com.kaiyu.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author mxxxl
 * @date 2020/7/21
 * @description
 */
@Controller
public class LoginController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session) {
        // 1.获取Subject
        Subject subject = SecurityUtils.getSubject();

        // 2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        // 3.执行登录方法
        try {
            subject.login(token);
            // 登录成功

            session.setAttribute("menus", menuService.selectAllMenu());

            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        } catch (UnknownAccountException e) {
            // 登录失败：用户名不存在
            model.addAttribute("msg", "用户名不存在！");
            return "index";
        } catch (IncorrectCredentialsException e) {
            // 登录失败：密码错误
            model.addAttribute("msg", "用户名或密码错误！");
            return "index";
        }
    }

    @GetMapping("/user/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/index.html";
    }

    @RequestMapping("/unAuth")
    public String unAuth() {
        return "/error/unAuth";
    }
}
