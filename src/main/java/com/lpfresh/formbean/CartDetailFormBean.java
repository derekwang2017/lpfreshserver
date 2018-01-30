package com.lpfresh.formbean;

import com.lpfresh.entity.Product;

import java.math.BigDecimal;

/**
 * Created by 87831 on 2018/1/26/0026.
 */
public class CartDetailFormBean extends Product {
    private BigDecimal amount;  //购物车中该商品数量
    private String headimgurl;  //产品目录图片地址

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }
}
