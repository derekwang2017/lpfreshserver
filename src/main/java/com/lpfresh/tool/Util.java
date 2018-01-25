package com.lpfresh.tool;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 87831 on 2018/1/25/0025.
 */
public class Util {

    public static boolean isEmpty(final String str) {
        if (str == null) {
            return true;
        }
        if (str.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public static String getLimitstr(int row, int page){
        if(page==0){
            page = 1;
        }
        if(row==0){
            row = 20;
        }
        int start = (page-1) * row;
        return " limit " + start + "," + row;
    }

    public static int getTotalPage(int totalcnt, int row){
        if(row==0){
            row = 20;
        }
        return (int) Math.ceil(totalcnt / (row * 1.0f));
    }

    public static String getToday(){
        Date today1=new Date();
        DateFormat fmt=new SimpleDateFormat("yyyyMMdd");
        return fmt.format(today1);
    }

    public static String getNowYYYYMMDDHHMMSS() {
        String result = "";
        SimpleDateFormat l_sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        result = l_sdf.format(new Date());
        return result;
    }

    public static boolean doUploadClientforfile(byte[] file, File existfile) throws Exception{

        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new ByteArrayInputStream(file));
            fos = new FileOutputStream(existfile);
            byte[] buf = new byte[8096];
            int size = 0;
            while ((size = bis.read(buf)) != -1)
                fos.write(buf, 0, size);
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            fos.close();
            bis.close();
        }

        System.out.println("上传文件成功======================");
        return true;
    }
}
