package com.lpfresh.dao;

import com.lpfresh.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 87831 on 2018/1/23/0023.
 */
@Mapper
public interface ProductDao {
    @Select("select * from lp_product")
    List<Product> getProductlist();
}
