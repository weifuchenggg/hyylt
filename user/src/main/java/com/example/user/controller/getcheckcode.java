package com.example.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@Controller
@RequestMapping("/code")
public class getcheckcode {
    // 定义常量表示当前输出的图片的高度和宽度
    public static final int WIDTH = 120;
    public static final int HEIGHT = 25;

    @RequestMapping("/getcode")
    public String getcode(HttpServletRequest request, HttpServletResponse response) {
        /**
         * 如果在Java中要写出一个图片那么使用到一个类（BufferedImage）
         */
        // 1 构建虚拟的图片独享，按照指定高度和宽度来构建一个类型为rgb模式的图片
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
                BufferedImage.TYPE_INT_RGB);

        // 2 获取这个图片绘制的画笔工具
        Graphics g = image.getGraphics();

        // 3 使用画笔来绘制图片的背景
        setBackgrond(g);

        // 4 绘制边框
        setBorder(g);

        // 5 绘制干扰线
        drawRandomLine(g);

        // 6 生成随机数并能把这个随机数返回。同时还能把这个随机数写入到图片中。
        String code = drawRandomNum(g);

        // 7 把获取到随机数放置到session对象中
        request.getSession().setAttribute("checkcode", code);

        // 8 就是把内存中的这个图片写出道客户端的浏览器上。
        response.setContentType("image/jpeg");// 写出客户端的是一个图片来的


        try {
            ImageIO.write(image, "jpg", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                response.getOutputStream().flush();
                response.getOutputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        return "login";
    }

    private String drawRandomNum(Graphics g) {
        //定义一个字符串，字符串保存生成出来的校验码
        String code = "";
        g.setColor(Color.black);
        //设定绘制字符串的字体、样式，大小.....
        g.setFont(new Font("宋体", Font.BOLD, 20));
        //定义基础字符串
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //设定绘制字符串的起始位置
        int x = 5;
        int y = 20;
        //使用循环来进行操作
        for (int i = 0; i < 4; i++) {
            String c = "" + base.charAt(new Random().nextInt(base.length()));
            g.drawString(c, x, y);
            //每次绘制字符的x轴的位置
            x = x + 30;
            code = code + c;
        }

        return code;
    }

    private void drawRandomLine(Graphics g) {
        g.setColor(Color.red);
        //绘制6条干扰线，随机生成
        for (int i = 0; i < 6; i++) {
            //随机得到干扰线的起始点
            int x1 = new Random().nextInt(WIDTH);//0-120
            int y1 = new Random().nextInt(HEIGHT);
            //得到终点
            int x2 = new Random().nextInt(WIDTH);//0-120
            int y2 = new Random().nextInt(HEIGHT);
            g.drawLine(x1, y1, x2, y2);
        }
    }

    private void setBorder(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawRect(1, 1, WIDTH - 2, HEIGHT - 2);
    }

    private void setBackgrond(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }

}


