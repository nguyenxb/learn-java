package com.nguyenxb.mapper;

import com.github.pagehelper.PageInfo;
import com.nguyenxb.pojo.ProductInfo;
import com.nguyenxb.pojo.ProductInfoExample;
import com.nguyenxb.pojo.vo.ProductInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductInfoMapper {
    int countByExample(ProductInfoExample example);

    int deleteByExample(ProductInfoExample example);

    int deleteByPrimaryKey(Integer pId);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    List<ProductInfo> selectByExample(ProductInfoExample example);

    ProductInfo selectByPrimaryKey(Integer pId);

    int updateByExampleSelective(@Param("record") ProductInfo record, @Param("example") ProductInfoExample example);

    int updateByExample(@Param("record") ProductInfo record, @Param("example") ProductInfoExample example);

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);

    int deleteBatch(String []ids);

    // 多条件查询商品
    List<ProductInfo> selectCondition(ProductInfoVo productInfoVo);

}