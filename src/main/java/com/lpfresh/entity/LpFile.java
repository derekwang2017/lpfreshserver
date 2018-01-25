package com.lpfresh.entity;

/**
 * Created by 87831 on 2018/1/25/0025.
 */
public class LpFile {
    private int lfid;
    private String lffilepath;
    private String lfdtm;

    public int getLfid() {
        return lfid;
    }

    public void setLfid(int lfid) {
        this.lfid = lfid;
    }

    public String getLffilepath() {
        return lffilepath;
    }

    public void setLffilepath(String lffilepath) {
        this.lffilepath = lffilepath;
    }

    public String getLfdtm() {
        return lfdtm;
    }

    public void setLfdtm(String lfdtm) {
        this.lfdtm = lfdtm;
    }
}
