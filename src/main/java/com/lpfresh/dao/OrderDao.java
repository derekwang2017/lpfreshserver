package com.lpfresh.dao;

import com.lpfresh.entity.LpCart;
import com.lpfresh.formbean.CartDetailFormBean;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 87831 on 2018/1/26/0026.
 */
@Mapper
public interface OrderDao {
    @Insert("insert into lp_cart (lclmid, lclpid, lcamount) values (#{lclmid}, #{lclpid}, #{lcamount})")
    @Options(useGeneratedKeys = true, keyProperty = "lcid")
    void insertMemberCart(LpCart cart);

    @Update("update lp_cart set lcamount=#{lcamount} where lclmid=#{lclmid} and lclpid=#{lclpid}")
    void updateCartProductAmount(@Param("lclmid") int lclmid, @Param("lclpid") int lclpid, @Param("lcamount") BigDecimal lcamount);

    @Delete("delete from lp_cart where lclmid=#{lclmid} and lclpid=#{lclpid}")
    void deleteCartProduct(@Param("lclmid") int lclmid, @Param("lclpid") int lclpid);

    @Select("select b.*, a.lcamount amount " +
            " from lp_cart a " +
            " left join lp_product b on b.lpid=a.lclpid " +
            " where lclmid=#{memberid}")
    List<CartDetailFormBean> getMemberCartDetail(@Param("memberid") int memberid);
}
