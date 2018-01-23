package com.lpfresh.controller;

import com.lpfresh.entity.Product;
import com.lpfresh.formbean.CommonRtn;
import com.lpfresh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 87831 on 2018/1/23/0023.
 */
@RestController

@RequestMapping(value = "product")
public class ProductCtl {
    @Autowired
    private ProductService productService;


    @RequestMapping(value = "list")
    public CommonRtn getProductlist(){
        List<Product> list = productService.getProductlist();
        CommonRtn<Product> rtn = new CommonRtn<>();
        rtn.setDatalist(list);
        return rtn;
    }
}
