package com.lpfresh.formbean;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 87831 on 2018/1/26/0026.
 */
public class CartFormBean {
    private BigDecimal totalprice;  //当前购物车总金额
    private List<CartDetailFormBean> detail;  //当前购物车详情

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public List<CartDetailFormBean> getDetail() {
        return detail;
    }

    public void setDetail(List<CartDetailFormBean> detail) {
        this.detail = detail;
    }
}
