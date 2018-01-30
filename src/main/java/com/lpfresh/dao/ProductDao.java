package com.lpfresh.dao;

import com.lpfresh.entity.LpFile;
import com.lpfresh.entity.LpProductFile;
import com.lpfresh.entity.Product;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
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

    @Select("select count(1) from lp_product where lpname=#{lpname} and lpid<>#{lpid}")
    int validProductNameExists(@Param("lpname") String lpname, @Param("lpid") int lpid);

    @Update("update lp_product set lpname=#{lpname}, lpdesc=#{lpdesc}, lpsaleprice=#{lpsaleprice}, lporignprice=#{lporignprice}, lpstockamount=#{lpstockamount}, lpheadimgid=#{lpheadimgid} where lpid=#{lpid}")
    void updateProductBaseinfo(Product product);

    @Insert("insert into lp_product (lpname, lpdesc, lpsaleprice, lporignprice, lpsortno, lpcreater, lpcreatdtm, lpstockamount, lpheadimgid)" +
            " values (#{lpname}, #{lpdesc}, #{lpsaleprice}, #{lporignprice}, #{lpsortno}, #{lpcreater}, #{lpcreatdtm}, #{lpstockamount}, #{lpheadimgid})")
    @Options(useGeneratedKeys = true, keyProperty = "lpid")
    void insertProduct(Product product);

    @Update("update lp_product_file set lpfdelflag=1 where lpflpid=#{lpid}")
    void setProductFileDelflag(@Param("lpid") int lpid);

    @Insert("<script>" +
            " insert into lp_product_file (lpflpid, lpflfid)" +
            " values " +
            " <foreach collection = \"datalist\" item = \"item\" index = \"index\" separator =\",\">" +
            " (#item.lpflpid, #{item.lpflfid})" +
            " </script>" +
            "</foreach>")
    void batchInsertProductFile(@Param("datalist") List<LpProductFile> datalist);

    @Update("update lp_product_file set lpdownflag=#{flag} where lpid=#{lpid}")
    void updateProductDownflag(@Param("flag") int flag, @Param("lpid") int lpid);

    @Update("update lp_product_file set lpsortno=#{sortno} where lpid=#{lpid}")
    void updateProductSortno(@Param("sortno") int sortno, @Param("lpid") int lpid);

    @Update("update lp_product_file set lpstockamount=#{amount} where lpid=#{lpid}")
    void updateProductStockamount(@Param("amount") BigDecimal amount, @Param("lpid") int lpid);
}
