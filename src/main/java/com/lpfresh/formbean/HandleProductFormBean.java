package com.lpfresh.formbean;

import java.math.BigDecimal;

/**
 * Created by 87831 on 2018/1/26/0026.
 */
public class HandleProductFormBean {
    private int lpid;
    private int flag;   //设置上架下架   1:下架
    private int sortno; //设置序号
    private BigDecimal stockamount;  //设置新库存

    public int getLpid() {
        return lpid;
    }

    public void setLpid(int lpid) {
        this.lpid = lpid;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getSortno() {
        return sortno;
    }

    public void setSortno(int sortno) {
        this.sortno = sortno;
    }

    public BigDecimal getStockamount() {
        return stockamount;
    }

    public void setStockamount(BigDecimal stockamount) {
        this.stockamount = stockamount;
    }
}
