package com.nguyenxb.service.impl;

import com.nguyenxb.dao.GoodsDao;
import com.nguyenxb.dao.SaleDao;
import com.nguyenxb.entity.Goods;
import com.nguyenxb.entity.Sale;
import com.nguyenxb.excep.NotEnoughException;
import com.nguyenxb.service.BuyGoodsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BuyGoodsServiceImpl implements BuyGoodsService {
    private SaleDao saleDao;
    private GoodsDao goodsDao;
    /*
    *  声明事务
    *
    *   propagation: 设置传播行为
    *   readOnly : 只读
    *   rollbackFor: 如果发生指定的异常, 一定回滚.
    *    处理逻辑:
    *     1. spring框架会先检查方法抛出的异常是不是在rollbackFor的
    *       属性值中,如果异常在rollbackFor列表中,不管是什么类型的异常,一定回滚.
    *      2.如果抛出的异常不在rollbackFor列表中, spring会判断异常是不是运行时异常,
    *       如果是,则一定回滚.
    *
    * */
   /* @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            rollbackFor = {
                    NullPointerException.class,
                    NotEnoughException.class
            }
    )*/
    /* 使用的是事务控制的默认值, 默认的传播行为是Required, 默认的
    隔离级别Default,默认抛出运行时异常的时候,就回滚事务.

    */
    @Transactional
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
