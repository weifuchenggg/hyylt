package com.example.user.controller;

import com.example.user.pojo.User;
import com.example.user.service.userservice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


@RequestMapping("/user")
@RestController
public class UserController {

    @Resource
    private userservice userservice;
    @Value("${server.port}")
    String port;



    @RequestMapping("/login")
    public String login(String userid, String userpwd, String code, HttpServletRequest request, HttpServletResponse response) {
        String code1 = (String) request.getSession().getAttribute("checkcode");

        if ((userid == null || userid.equals("")) || (userpwd == null || userpwd.equals(""))) {
            return "false";
        }
        System.out.print(userid + " " + userpwd);
        User user = new User();
        user.setUserid(userid);
        user.setUserpassword(userpwd);
        int i = userservice.userlogin(user.getUserid(), user.getUserpassword());
        if (i > 0) {
            if (code.equals(code1)) {
                request.getSession().setAttribute("userid", userid);
                System.out.print("登录成功");
            } else {
                System.out.print("登录失败,验证码错误!");
                return "false";
            }

        } else {
            System.out.print("登录失败,用户名或密码错误!");
            return "false";
        }
        return "success";
    }

    /**
     * 按id修改信息
     *
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/update")
    public String update(User user, HttpServletRequest request) {
        System.out.print(user.getUserid() + " " + user.getUserpassword());
        String userid = (String) request.getSession().getAttribute("userid");
        System.out.print(userid);
        user.setUserid(userid);
        int u = userservice.userupdate(user);
        if (u > 0) {
            System.out.print("ssss");
        }
        return "login";
    }

    /**
     * 按id查找個人信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/getbyid")
    public String getuserbyid(HttpServletRequest request) {
        String userid = (String) request.getSession().getAttribute("userid");
        User user = userservice.getuserbyid(userid);
//        Object uuid = UUID.randomUUID();
//        System.out.print(uuid);
        System.out.print(user);
        return "aa";
    }

}
