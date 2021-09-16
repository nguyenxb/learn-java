package com.nguyenxb.test;

import com.nguyenxb.mapper.ProductInfoMapper;
import com.nguyenxb.pojo.ProductInfo;
import com.nguyenxb.pojo.vo.ProductInfoVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_dao.xml","classpath:applicationContext_service.xml"})
public class MyTest1 {
    @Autowired
    ProductInfoMapper mapper;

    @Test
    public void testSelectCondition(){
        ProductInfoVo productInfoVo = new ProductInfoVo();
        productInfoVo.setPname("");
        productInfoVo.setTypeid(-1);
        productInfoVo.setLprice(4000.0);
//        productInfoVo.setHprice(4700.0);
        List<ProductInfo> productInfoList = mapper.selectCondition(productInfoVo);
        productInfoList.forEach(vo -> System.out.println(vo.toString()));
    }
}
