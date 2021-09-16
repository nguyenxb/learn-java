package com.nguyenxb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nguyenxb.mapper.ProductInfoMapper;
import com.nguyenxb.pojo.ProductInfo;
import com.nguyenxb.pojo.ProductInfoExample;
import com.nguyenxb.pojo.vo.ProductInfoVo;
import com.nguyenxb.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    ProductInfoMapper productInfoMapper;

    // 返回商品列表
    @Override
    public PageInfo splitPage(int pageNum, int pageSize) {
        // 使用分页插件 PageHelper工具类完成分页设置
        PageHelper.startPage(pageNum,pageSize);
        // 对PageInfo的数据进行封装
        // 进行有条件的查询操作,必须要创建ProductInfoExample对象.
        ProductInfoExample productInfoExample = new ProductInfoExample();
        // 设置主键降序排序
        productInfoExample.setOrderByClause("p_id desc");
        // 查询商品列表
        List<ProductInfo> productInfoList = productInfoMapper.selectByExample(productInfoExample);

        // 将返回商品列表封装到PageInfo对象中
        PageInfo<ProductInfo> pageInfo = new PageInfo<>(productInfoList);
        return pageInfo;
    }
    // 保存新增加的商品信息
    @Override
    public int save(ProductInfo info) {
        if (info.getpPrice() < 0 || info.getpNumber() < 0){
            return -1;
        }
       return productInfoMapper.insert(info);
    }
    // 按照主键id 查询商品
    @Override
    public ProductInfo getByID(int pid){
        return productInfoMapper.selectByPrimaryKey(pid);
    }

    @Override
    public int update(ProductInfo info) {
        if (info.getpNumber() <=0 || info.getpPrice() < 0){
            return -1;
        }
        return productInfoMapper.updateByPrimaryKey(info);
    }

    @Override
    public int delete(int pid) {
        return productInfoMapper.deleteByPrimaryKey(pid);
    }

    @Override
    public int delete(String[] pids) {
        return productInfoMapper.deleteBatch(pids);
    }

    @Override
    public List<ProductInfo> selectCondition(ProductInfoVo infoVo) {
        return productInfoMapper.selectCondition(infoVo);
    }

    @Override
    public PageInfo splitPageVo(ProductInfoVo productInfoVo, int pageSize) {
        // 取出集合之前要先设置PageHelper.startPage()属性.
        PageHelper.startPage(productInfoVo.getPage(),pageSize);
        List<ProductInfo> list = productInfoMapper.selectCondition(productInfoVo);
        return new PageInfo<ProductInfo>(list);
    }


}
