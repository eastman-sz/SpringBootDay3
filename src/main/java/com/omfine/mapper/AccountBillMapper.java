package com.omfine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.omfine.bean.AccountBill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface AccountBillMapper extends BaseMapper<AccountBill> {

    // @Select("select * from account_bill where amount >= #{amount}")
    // List<AccountBill> getAllBills(int amount);

    /**
     * 相同的方法名，会优先调用前面的方法。
     * 如果这里写了sql语句，那么，mapper.xml里就不需要写相同的方法了。
     * @return
     */
    @Select("select * from account_bill")
    List<AccountBill> getAllBills();

}
