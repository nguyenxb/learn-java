package com.nguyenxb.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageInfo;
import com.nguyenxb.pojo.ProductInfo;
import com.nguyenxb.pojo.vo.ProductInfoVo;
import com.nguyenxb.service.ProductInfoService;
import com.nguyenxb.utils.FileNameUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/prod")
public class ProductInfoAction {
    private static final int PAGE_SIZE = 5;
    String saveFileName = "";
    @Autowired
    ProductInfoService productInfoService;
    // 页面加载处理
    @RequestMapping("/split.action")
    public ModelAndView split(){
        ModelAndView modelAndView = new ModelAndView();
        PageInfo pageInfo = productInfoService.splitPage(1, PAGE_SIZE);
        modelAndView.addObject("info",pageInfo);
        modelAndView.setViewName("product");
        return modelAndView;
    }
    // 分页翻页处理
    @RequestMapping("/ajaxsplit.action")
    @ResponseBody
    public void ajaxSplit(HttpSession session,ProductInfoVo vo){
        PageInfo info = productInfoService.splitPageVo(vo, PAGE_SIZE);
        session.setAttribute("info",info);
    }
    // 异步ajax文件上传处理.
    @RequestMapping("/ajaxImg.action")
    @ResponseBody
    public Object ajaxImg(HttpServletRequest request,MultipartFile pimage){
        // 提取生成文件 UUID + 上传图片的后缀.jpg, .png
         saveFileName = FileNameUtil.getUUIDFileName()+FileNameUtil.getFileType(pimage.getOriginalFilename());
        // 获取项目中图片的存储路径
        String path = request.getServletContext().getRealPath("/image_big");

        // 转存
        try {
//            path = "F:\\workplace\\Javaplace\\mimiSSM\\src\\main\\webapp\\image_big\\";
            pimage.transferTo(new File(path+saveFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 返回客户端json对象,封装图片的路径,为了在页面实现立即回显
        JSONObject object = new JSONObject();
        object.put("imgurl",saveFileName);
        return object.toString();
    }
    @RequestMapping("/save.action")
    public ModelAndView save(ProductInfo info){
        ModelAndView modelAndView = new ModelAndView();
        info.setpImage(saveFileName);
        info.setpDate(new Date());
        // info对象中有表单提交上来的5个数据,有异步ajax上来的图片名称数据,
        //有上架时间的数据.
        int num = -1;
        try {
            num =productInfoService.save(info);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (num > 0){
            modelAndView.addObject("msg","增加成功!");
            // 增加成功后将页面跳转到分页显示那边
            modelAndView.setViewName("forward:/prod/split.action");
        }else {
            modelAndView.addObject("msg","增加失败!");
            // 如果增加失败了,依旧保持在当前页面.
            modelAndView.setViewName("addproduct");
        }

        saveFileName = "";
        return modelAndView;
    }

    @RequestMapping("/one.action")
    public ModelAndView one(int pid){
        ModelAndView modelAndView = new ModelAndView();
        ProductInfo productInfo = productInfoService.getByID(pid);
        modelAndView.addObject("prod",productInfo);
        modelAndView.setViewName("update");
        return modelAndView;
    }

    @RequestMapping("/update.action")
    public ModelAndView updateProd(ProductInfo info){
        ModelAndView modelAndView = new ModelAndView();
        //因为ajax 的异步上传图片,如果有上传过,则saveFileName里有上传上来的图片名称.
        // 如果没有使用一般ajax上传过图片,则saveFileName="",
        // 实体类 info使用隐藏表单域提供上来的pImage原始图片名称.
        if (!"".equals(saveFileName)){
            info.setpImage(saveFileName);
        }
        // 完成更新操作
        int num = -1;
        num = productInfoService.update(info);

        if (num > 0){
            // 此时说明更新成功
            modelAndView.addObject("msg","更新成功!");
            modelAndView.setViewName("forward:/prod/split.action");
        }else {
            modelAndView.addObject("msg","更新失败!");
            modelAndView.setViewName("update");
        }
        // 处理完更新后,saveFileName里有可能有数据,
        // 而下一次更新时要使用这个变量做判断的依据,就会出错,所有必须清空
        saveFileName = "";
        return modelAndView;
    }

    @RequestMapping("/delete.action")
    public String delete(HttpServletRequest request,int pid){
//        System.out.println(pid);
        int num = -1;
       try {
           num = productInfoService.delete(pid);
       }catch (Exception e){
           e.printStackTrace();
       }
       if (num > 0){
          request.setAttribute("msg","删除成功!");
       }else {
           request.setAttribute("msg","删除失败!");
       }
       return "forward:/prod/deleteAjaxSplit.action";
    }
    @RequestMapping(value = "/deleteAjaxSplit.action",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String deleteAjaxSplit(HttpServletRequest request){
      // 取得第一页的数据
        PageInfo info = productInfoService.splitPage(1,PAGE_SIZE);
        request.getSession().setAttribute("info",info);
        return (String) request.getAttribute("msg");
    }

    // 批量删除商品
    @RequestMapping("/deleteBatch.action")
    public String deleteBatch(HttpServletRequest request,String pids){
//        System.out.println("pids:"+pids);
        String[] pidStr = pids.split(",");
        try {
            int nums = productInfoService.delete(pidStr);
            if (nums > 0){
                request.setAttribute("msg","批量删除成功!");
            }else {
                request.setAttribute("msg","批量删除失败!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg","存在不可删除的商品!");
        }
        return "forward:/prod/deleteAjaxSplit.action";
    }

    // 多条件查询
    @RequestMapping("/selectCondition.action")
    @ResponseBody
    public void selectCondition(HttpSession session,ProductInfoVo productInfoVo){
        List<ProductInfo> infoList = productInfoService.selectCondition(productInfoVo);
        session.setAttribute("list",infoList);
    }


}
