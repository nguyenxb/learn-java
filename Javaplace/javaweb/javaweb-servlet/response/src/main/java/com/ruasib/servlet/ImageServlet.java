package com.ruasib.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // 设置客户端每隔3秒自动刷新页面
        resp.setHeader("refresh","3");
        // 创建带缓冲区的图片对象
        BufferedImage image = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        // 使用笔画出图片
        Graphics2D graphics2D = (Graphics2D) image.getGraphics(); // 笔
        // 设置笔的颜色
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(0,0,80,20);
        // 给图片写数据
        graphics2D.setColor(Color.BLUE);
        graphics2D.setFont(new Font(null,Font.BOLD,20));
        graphics2D.drawString(makeNum(),0,20);

        // 将图片返回到客户端
        resp.setContentType("image/jpg");
        // 网站存在缓存 ，不让网站缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

        // 将图片写给浏览器
        boolean write = ImageIO.write(image,"jpg",resp.getOutputStream());


    }

    private String makeNum() {
        Random random = new Random();
        String num = random.nextInt(9999)+"";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4 - num.length(); i++) {
            sb.append(0);
        }
        return sb.toString()+ num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
