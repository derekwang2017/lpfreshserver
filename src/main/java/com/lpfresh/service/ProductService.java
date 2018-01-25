package com.lpfresh.service;

import com.lpfresh.dao.ProductDao;
import com.lpfresh.entity.LpFile;
import com.lpfresh.entity.Product;
import com.lpfresh.tool.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
}
