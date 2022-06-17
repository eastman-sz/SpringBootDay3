package com.omfine.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.omfine.bean.AccountBill;
import com.omfine.mapper.AccountBillMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class AccountBillServiceImp implements AccountBillService {

    @Resource
    private AccountBillMapper accountBillMapper = null;

    @Override
    public int insert(AccountBill accountBill) {
        return accountBillMapper.insert(accountBill);
    }

    @Override
    public List<AccountBill> selectList() {
        return accountBillMapper.selectList(null);
    }

    @Override
    public AccountBill selectOne(AccountBill accountBill) {
        QueryWrapper<AccountBill> wrapper = Wrappers.query();
        HashMap<String , Object> params = new HashMap<>();
        params.put("unique_id" , accountBill.uniqueId);
        params.put("c_time" , accountBill.cTime);
        wrapper.allEq(params);
        return accountBillMapper.selectOne(wrapper);
    }

    @Override
    public AccountBill selectOne(long billId) {
        QueryWrapper<AccountBill> wrapper = Wrappers.query();
        HashMap<String , Object> params = new HashMap<>();
        params.put("bill_id" , billId);
        wrapper.allEq(params);
        return accountBillMapper.selectOne(wrapper);
    }

    @Override
    public List<AccountBill> selectPage(int page, int rows) {
        IPage<AccountBill> iPage = new Page<>(page , rows);
        QueryWrapper<AccountBill> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("happened_time_stamp");
        // queryWrapper.orderByAsc("happened_time_stamp");

        IPage<AccountBill> resultPage = accountBillMapper.selectPage(iPage , queryWrapper);
        List<AccountBill> users = resultPage.getRecords();

        return users;
    }

    @Override
    public List<AccountBill> selectPage(int page, int rows, long startTimeStamp, long endTimeStamp) {
        IPage<AccountBill> iPage = new Page<>(page , rows);
        QueryWrapper<AccountBill> queryWrapper = new QueryWrapper<>();
        // queryWrapper.orderByDesc("happened_time_stamp");
        queryWrapper.orderByDesc("happened_time_stamp");
        queryWrapper.between(true , "happened_time_stamp" , startTimeStamp , endTimeStamp);

        IPage<AccountBill> resultPage = accountBillMapper.selectPage(iPage , queryWrapper);
        List<AccountBill> users = resultPage.getRecords();

        return users;
    }

    @Override
    public List<AccountBill> getAllBills() {
        return accountBillMapper.getAllBills();
    }


}
