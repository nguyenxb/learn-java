package com.nguyenxb.dao;

import com.nguyenxb.entity.Sale;

public interface SaleDao {
    // 增加销售记录
    int insertSale(Sale sale);
}
