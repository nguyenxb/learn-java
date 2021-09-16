package com.nguyenxb.service.impl;

import com.nguyenxb.mapper.ProductInfoMapper;
import com.nguyenxb.mapper.ProductTypeMapper;
import com.nguyenxb.pojo.ProductType;
import com.nguyenxb.pojo.ProductTypeExample;
import com.nguyenxb.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    ProductTypeMapper productTypeMapper;
    @Override
    public List<ProductType> getAll() {
        return productTypeMapper.selectByExample(new ProductTypeExample());
    }
}
