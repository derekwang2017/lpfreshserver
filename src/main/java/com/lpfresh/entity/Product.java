package com.lpfresh.entity;

import java.math.BigDecimal;

/**
 * Created by 87831 on 2018/1/23/0023.
 */
public class Product {
    private int lpid;
    private String lpname;
    private String lpdesc;
    private BigDecimal lpsaleprice;
    private BigDecimal lporignprice;
    private int lpsortno;
    private int lpcreater;
    private String lpcreatdtm;
    private int lpdownflag;
    private BigDecimal lpstockamount;

    public int getLpid() {
        return lpid;
    }

    public void setLpid(int lpid) {
        this.lpid = lpid;
    }

    public String getLpname() {
        return lpname;
    }

    public void setLpname(String lpname) {
        this.lpname = lpname;
    }

    public String getLpdesc() {
        return lpdesc;
    }

    public void setLpdesc(String lpdesc) {
        this.lpdesc = lpdesc;
    }

    public BigDecimal getLpsaleprice() {
        return lpsaleprice;
    }

    public void setLpsaleprice(BigDecimal lpsaleprice) {
        this.lpsaleprice = lpsaleprice;
    }

    public BigDecimal getLporignprice() {
        return lporignprice;
    }

    public void setLporignprice(BigDecimal lporignprice) {
        this.lporignprice = lporignprice;
    }

    public int getLpsortno() {
        return lpsortno;
    }

    public void setLpsortno(int lpsortno) {
        this.lpsortno = lpsortno;
    }

    public int getLpcreater() {
        return lpcreater;
    }

    public void setLpcreater(int lpcreater) {
        this.lpcreater = lpcreater;
    }

    public String getLpcreatdtm() {
        return lpcreatdtm;
    }

    public void setLpcreatdtm(String lpcreatdtm) {
        this.lpcreatdtm = lpcreatdtm;
    }

    public int getLpdownflag() {
        return lpdownflag;
    }

    public void setLpdownflag(int lpdownflag) {
        this.lpdownflag = lpdownflag;
    }

    public BigDecimal getLpstockamount() {
        return lpstockamount;
    }

    public void setLpstockamount(BigDecimal lpstockamount) {
        this.lpstockamount = lpstockamount;
    }
}
