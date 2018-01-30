package com.lpfresh.controller;

import com.lpfresh.entity.Product;
import com.lpfresh.formbean.CommonRtn;
import com.lpfresh.formbean.HandleProductFormBean;
import com.lpfresh.formbean.ProductFormBean;
import com.lpfresh.formbean.ProductSearchFormBean;
import com.lpfresh.service.ProductService;
import com.lpfresh.tool.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public CommonRtn getProductlist(@RequestBody ProductSearchFormBean formBean){
        StringBuilder filter = new StringBuilder();
        if(!Util.isEmpty(formBean.getLpname())){
            filter.append(" and lpname like '%").append(formBean.getLpname()).append("%'");
        }

        if(Util.isEmpty(formBean.getSidx())){
            formBean.setSidx("lpsortno");
        }
        if(Util.isEmpty(formBean.getSord())){
            formBean.setSord("asc");
        }
        String orderstr = " order by " + formBean.getSidx() + " " + formBean.getSord();
        String limitstr = Util.getLimitstr(formBean.getRow(), formBean.getPage());
        List<Product> list = productService.getProductlist(filter.toString(), orderstr + limitstr);
        int totalcnt = productService.getProductlistSize(filter.toString());
        int totalpage = Util.getTotalPage(totalcnt, formBean.getRow());
        CommonRtn<Product> rtn = new CommonRtn<>();
        rtn.setDatalist(list);
        rtn.setTotalcnt(totalcnt);
        rtn.setTotalpage(totalpage);
        return rtn;
    }

    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    public @ResponseBody
    CommonRtn fileUpload(@RequestParam MultipartFile file) throws Exception {
        int fileid = productService.saveFile(file);
        CommonRtn<Integer> rtn = new CommonRtn();
        rtn.setData(fileid);
        return rtn;
    }

    //新增修改商品
    @RequestMapping(value = "save")
    public CommonRtn saveProduct(@RequestBody ProductFormBean formBean){
        return productService.saveProduct(formBean);
    }

    //下架商品
    @RequestMapping(value = "down")
    public CommonRtn downProduct(@RequestBody HandleProductFormBean formBean){
        CommonRtn rtn = new CommonRtn();
        if(formBean.getLpid()==0){
            rtn.setStatus(1);
            rtn.setMsg("参数错误");
        } else {
            productService.setProductDownSvc(formBean.getLpid(), formBean.getFlag());
            rtn.setMsg("设置成功");
        }
        return rtn;
    }

    //设置商品展示序号
    @RequestMapping(value = "setsortno")
    public CommonRtn setProductSortno(@RequestBody HandleProductFormBean formBean){
        CommonRtn rtn = new CommonRtn();
        if(formBean.getLpid()==0){
            rtn.setStatus(1);
            rtn.setMsg("参数错误");
        } else {
            productService.setProductSortnoSvc(formBean.getLpid(), formBean.getSortno());
            rtn.setMsg("设置成功");
        }
        return rtn;
    }

    //设置商品库存
    @RequestMapping(value = "setstockamount")
    public CommonRtn setProductStock(@RequestBody HandleProductFormBean formBean){
        CommonRtn rtn = new CommonRtn();
        if(formBean.getLpid()==0){
            rtn.setStatus(1);
            rtn.setMsg("参数错误");
        } else {
            productService.setProductStockamountSvc(formBean.getLpid(), formBean.getStockamount());
            rtn.setMsg("设置成功");
        }
        return rtn;
    }

    //获取商品详情
    @RequestMapping(value = "detail")
    public CommonRtn getProductDetail(@RequestBody HandleProductFormBean formBean){
        CommonRtn rtn = new CommonRtn();
        if(formBean.getLpid()==0){
            rtn.setStatus(1);
            rtn.setMsg("参数错误");
        } else {
            productService.setProductStockamountSvc(formBean.getLpid(), formBean.getStockamount());
            rtn.setMsg("设置成功");
        }
        return rtn;
    }
}
