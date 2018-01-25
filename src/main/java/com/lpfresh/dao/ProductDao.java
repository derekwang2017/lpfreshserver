package com.lpfresh.dao;

import com.lpfresh.entity.LpFile;
import com.lpfresh.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 87831 on 2018/1/23/0023.
 */
@Mapper
public interface ProductDao {
    @Select("select * from lp_product where lpdownflag=0 ${filter} ${orderlimit}")
    List<Product> getProductlist(@Param("String filter") String filter, @Param("orderlimit") String orderlimit);

    @Select("select count(1) from lp_product where lpdownflag=0 ${filter}")
    int getProductlistCnt(@Param("String filter") String filter);

    @Insert("insert into lp_file (lffilepath, lfdtm) values (#{lffilepath}, #{lfdtm})")
    @Options(useGeneratedKeys = true, keyProperty = "lfid")
    void insertFile(LpFile file);
}
