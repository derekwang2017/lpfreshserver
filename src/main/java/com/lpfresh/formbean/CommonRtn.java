package com.lpfresh.formbean;

import java.util.List;

/**
 * Created by 87831 on 2018/1/23/0023.
 */
public class CommonRtn<T> {
    private int status;
    private String msg;
    private T data;
    private List<T> datalist;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<T> getDatalist() {
        return datalist;
    }

    public void setDatalist(List<T> datalist) {
        this.datalist = datalist;
    }
}
