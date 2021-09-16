package com.nguyenxb.service;

import com.github.pagehelper.PageInfo;
import com.nguyenxb.pojo.ProductInfo;
import com.nguyenxb.pojo.vo.ProductInfoVo;

import java.util.List;

public interface ProductInfoService {


    /**
     * @param pageNum 用户当前页
     * @param pageSize 每页的条数
     * @return 商品列表
     */
    PageInfo splitPage(int pageNum, int pageSize);


    /**
     * @param info 新增的商品信息
     * @return 返回是否成功添加商品信息
     */
    int save(ProductInfo info);

    /**
     * @param pid 客户端上传的商品id
     * @return 返回商品信息.
     */
    ProductInfo getByID(int pid);

    /**
     * @param info 要更新的商品信息
     * @return  是否成功更新
     */
    int update(ProductInfo info);


    /**
     * @param pid 商品主键
     * @return 是否成功删除
     */
    int delete(int pid);

    /**
     * @param pids 要进行批量删除的商品主键
     * @return 删除影响行数
     */
    int delete(String []pids);

    /**
     * @param infoVo 查询的条件
     * @return 商品列表
     */
    List<ProductInfo> selectCondition(ProductInfoVo infoVo);

    /**
     * @param productInfoVo 上传的查询条件
     * @param pageSize 页面显示商品数量
     * @return 页面数据
     */
    // 分页多条件查询
    PageInfo splitPageVo(ProductInfoVo productInfoVo, int pageSize);
}
