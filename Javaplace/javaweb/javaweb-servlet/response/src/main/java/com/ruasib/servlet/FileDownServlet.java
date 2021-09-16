package com.ruasib.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class FileDownServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取要下载文件的路径
        String realPath = "D:\\java_workplace\\javaweb\\javaweb-servlet\\response\\" +
                        "target\\response-1.0-SNAPSHOT\\WEB-INF\\classes\\莉雅.jpg";
        System.out.println("要下载的文件路径："+realPath);
        //2. 下载的文件名是什么？
        // 最后一个 // 后的
        String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);
        //3. 设置想办法让浏览器能够支持(Content-Disposition)下载我们需要的东西,使用URLEncoder.encode对中文文件名进行编码，否则就可能乱码
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
        //4. 获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        //5. 创建缓冲区
        int len = 0;
        byte[] buf = new byte[1024];
        //6. 获取OutputStream对象
        ServletOutputStream out = resp.getOutputStream();
        //7. 将FileOutputStream流写入到buffer缓冲区
        // 使用OutputStream将缓冲区中的数据输出到客户端
        while((len=in.read(buf))!=-1){
            out.write(buf,0,len);
        }
        in.close();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }
}
