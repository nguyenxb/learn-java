package com.nguyenxb.service.impl;

import com.nguyenxb.dao.GoodsDao;
import com.nguyenxb.dao.SaleDao;
import com.nguyenxb.entity.Goods;
import com.nguyenxb.entity.Sale;
import com.nguyenxb.excep.NotEnoughException;
import com.nguyenxb.service.BuyGoodsService;

//
public class BuyGoodsServiceImpl implements BuyGoodsService {
    private SaleDao saleDao;
    private GoodsDao goodsDao;
    @Override
    public void buy(Integer goodsId, Integer nums) {
        System.out.println("======buy 方法的开始===");
        // 记录销售信息, 向sale表添加记录
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleDao.insertSale(sale);

        // 更新库存
        Goods goods = goodsDao.selectGoods(goodsId);
        if (goods==null){
            // 商品不存在
            throw new NullPointerException("编号是:"+goodsId+", 商品不存在");
        }else if ( goods.getAmount() < nums){
            throw new NotEnoughException("编号是:"+goodsId+",商品库存不足");
        }

        // 修改库存
        Goods buyGoods = new Goods();
        buyGoods.setId(goodsId);
        buyGoods.setAmount(nums);
        goodsDao.updateGoods(buyGoods);
        System.out.println("=========buy方法完成===========");
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }
}
