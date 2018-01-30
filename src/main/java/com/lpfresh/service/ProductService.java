package com.lpfresh.service;

import com.lpfresh.dao.ProductDao;
import com.lpfresh.entity.LpFile;
import com.lpfresh.entity.LpProductFile;
import com.lpfresh.entity.Product;
import com.lpfresh.formbean.CommonRtn;
import com.lpfresh.formbean.ProductFormBean;
import com.lpfresh.tool.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 87831 on 2018/1/23/0023.
 */
@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public List<Product> getProductlist(String filter, String orderlimit) {
        return productDao.getProductlist(filter, orderlimit);
    }

    public int getProductlistSize(String filter) {
        return productDao.getProductlistCnt(filter);
    }

    public int saveFile(MultipartFile file) {
        // 文件后缀
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        String now = Util.getNowYYYYMMDDHHMMSS();
        String today = now.substring(0, 8);
        String basepath = "/media/img/lpfresh/" + today;
        File existfile = new File(basepath);
        if (!existfile.exists()) {
            boolean aa = existfile.mkdir();
            System.out.println(aa);
        }

        String newfilename = now + "." + suffix;
        String filepath = basepath + File.separator + newfilename;

        File saveFile = new File(filepath);
        int fileid = 0;
        try {
            if (!saveFile.exists()) {
                saveFile.createNewFile();
            }
            boolean success = Util.doUploadClientforfile(file.getBytes(), saveFile);
            if (success) {
                LpFile lpFile = new LpFile();
                lpFile.setLfdtm(now);
                lpFile.setLffilepath(filepath);
                productDao.insertFile(lpFile);
                fileid = lpFile.getLfid();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileid;
    }

    public CommonRtn saveProduct(ProductFormBean formBean){
        CommonRtn<Integer> rtn = new CommonRtn<>();
        int lpid = formBean.getLpid();
        //验证名称唯一性
        String lpname = formBean.getLpname();
        if(Util.isEmpty(lpname)){
            rtn.setStatus(1);
            rtn.setMsg("商品名称不能为空");
            return rtn;
        }
        int nameExists = productDao.validProductNameExists(lpname, lpid);
        if(nameExists>0){
            rtn.setStatus(1);
            rtn.setMsg("商品名称已经存在");
            return rtn;
        }
        if(lpid>0){
            //update

            productDao.updateProductBaseinfo(formBean);
            //设置图片删除
            productDao.setProductFileDelflag(lpid);
        } else {
            //insert
            formBean.setLpsortno(0);
            formBean.setLpcreatdtm(Util.getNowYYYYMMDDHHMMSS());
            formBean.setLpcreater(1);
            productDao.insertProduct(formBean);
            lpid = formBean.getLpid();
        }
        String imgids = formBean.getImgids();
        if(!Util.isEmpty(imgids)){
            String[] imgidsarr = imgids.split(",");
            if(imgidsarr.length>0){
                List<LpProductFile> filelist = new ArrayList<>();
                for(String idstr : imgidsarr){
                    int id = Util.convertToInt(idstr);
                    if(id==0){
                        continue;
                    }
                    LpProductFile file = new LpProductFile();
                    file.setLpflpid(lpid);
                    file.setLpflfid(id);
                    filelist.add(file);
                }
                if(filelist.size()>0){
                    productDao.batchInsertProductFile(filelist);
                }
            }
        }
        rtn.setData(lpid);
        rtn.setMsg("保存成功");

        return rtn;
    }

    public void setProductDownSvc(int lpid, int flag){
        productDao.updateProductDownflag(flag, lpid);
    }

    public void setProductSortnoSvc(int lpid, int sortno){
        productDao.updateProductSortno(sortno, lpid);
    }

    public void setProductStockamountSvc(int lpid, BigDecimal amount){
        productDao.updateProductStockamount(amount, lpid);
    }
}
