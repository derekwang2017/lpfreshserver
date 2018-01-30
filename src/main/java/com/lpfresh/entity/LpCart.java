package com.lpfresh.entity;

import java.math.BigDecimal;

/**
 * Created by 87831 on 2018/1/26/0026.
 */
public class LpCart {
    private int lcid;
    private int lclmid;
    private int lclpid;
    private BigDecimal lcamount;

    public int getLcid() {
        return lcid;
    }

    public void setLcid(int lcid) {
        this.lcid = lcid;
    }

    public int getLclmid() {
        return lclmid;
    }

    public void setLclmid(int lclmid) {
        this.lclmid = lclmid;
    }

    public int getLclpid() {
        return lclpid;
    }

    public void setLclpid(int lclpid) {
        this.lclpid = lclpid;
    }

    public BigDecimal getLcamount() {
        return lcamount;
    }

    public void setLcamount(BigDecimal lcamount) {
        this.lcamount = lcamount;
    }
}
