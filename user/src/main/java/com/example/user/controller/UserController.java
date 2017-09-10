package com.example.user.controller;
import com.example.user.pojo.User;
import com.example.user.service.userservice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RequestMapping("/user")
@Controller
public class UserController {

    @Resource
    private userservice userservice;
    @Value("${server.port}")
    String port;
    @RequestMapping("/index")
    public String index()
    {

        return "aa";
    }
    @RequestMapping("/login")
    public String login(String userid,String userpwd,String code,HttpServletRequest request,HttpServletResponse response){
        String code1 =(String) request.getSession().getAttribute("checkcode");

        if((userid==null ||userid.equals(""))||(userpwd==null || userpwd.equals("")))
        {
            return "login";
        }
        System.out.print(userid+" "+userpwd);
        User user = new User();
        user.setUsername(userid);
        user.setUserpassword(userpwd);
        int i =userservice.userlogin(user.getUsername(),user.getUserpassword());
        if (i>0)
            {
                if(code.equals(code1))
                {
                    System.out.print("登录成功");
                }else {
                    System.out.print("登录失败,验证码错误!");
                }

            }
        else {
            System.out.print("登录失败,用户名或密码错误!");
            }
        return "aa";
    }

}
