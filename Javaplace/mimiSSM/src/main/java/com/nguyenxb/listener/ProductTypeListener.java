package com.nguyenxb.listener;

import com.nguyenxb.pojo.ProductType;
import com.nguyenxb.service.ProductTypeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class ProductTypeListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // 手工从Spring容器中取出ProductTypeServiceImpl的对象.
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_*.xml");
        ProductTypeService productTypeService = (ProductTypeService) context.getBean("productTypeServiceImpl");
        List<ProductType> typeList = productTypeService.getAll();
        // 放入全局应用作用域中,供新增页面,修改页面,前台查询提供全部的商品类别
        servletContextEvent.getServletContext().setAttribute("ptlist",typeList);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
