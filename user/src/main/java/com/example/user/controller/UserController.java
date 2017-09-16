package com.example.user.controller;

import com.example.user.pojo.User;
import com.example.user.service.userservice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RequestMapping("/user")
@Controller
public class UserController {

    @Resource
    private userservice userservice;
    @Value("${server.port}")
    String port;


    @RequestMapping("/login")
    @ResponseBody
    public String login(String userid, String userpwd, String code, HttpServletRequest request, HttpServletResponse response) {
        String code1 = (String) request.getSession().getAttribute("checkcode");

        if ((userid == null || userid.equals("")) || (userpwd == null || userpwd.equals(""))) {
            return "false";
        }
        System.out.print(userid + " " + userpwd);
        User user = new User();
        user.setUserid(userid);
        user.setUserpassword(userpwd);
        List<User> users = userservice.userlogin(user.getUserid(), user.getUserpassword());
        System.out.print(users.get(0));
        if (users.size() > 0) {
            if (code.equals(code1)) {
                request.getSession().setAttribute("user", user.getUserid());
                request.getSession().setAttribute("user",users.get(0));
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
    public String update(User user, HttpServletRequest request,HttpServletResponse response) {
        System.out.print(user.getUserid() + " " + user.getUserpassword());
        String userid = (String) request.getSession().getAttribute("userid");
        System.out.print(userid);

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

    @RequestMapping("/getUserById")
    public String getUserById(HttpServletRequest request) {
        String userid = (String) request.getSession().getAttribute("userid");
        User user = userservice.getuserbyid("wyc");
        request.setAttribute("user", user);
        List lists = new ArrayList();
        lists.add("dd");
        lists.add("ddd");
        request.setAttribute("lists", lists);
        System.out.print(user);
        return "infoshow";
    }
    @RequestMapping("/adduser")
    public String  adduser(@Valid User user, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            System.out.print(bindingResult.getFieldError().getDefaultMessage());
return  null;
        }
        return "ddd";
    }

}
