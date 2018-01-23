package com.lpfresh.service;

import com.lpfresh.dao.ProductDao;
import com.lpfresh.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 87831 on 2018/1/23/0023.
 */
@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public List<Product> getProductlist(){
        return productDao.getProductlist();
    }
}
