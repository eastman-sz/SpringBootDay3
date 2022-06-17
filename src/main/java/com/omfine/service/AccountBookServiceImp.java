package com.omfine.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.omfine.bean.AccountBook;
import com.omfine.mapper.AccountBookMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountBookServiceImp implements AccountBookService{

    @Resource
    private AccountBookMapper accountBookMapper = null;

    @Override
    public int insert(AccountBook accountBook) {
        return accountBookMapper.insert(accountBook);
    }

    @Override
    public AccountBook getAccountBook(int uid, long cTime) {
        QueryWrapper<AccountBook> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid" , uid);
        queryWrapper.eq("c_time" , cTime);
        return accountBookMapper.selectOne(queryWrapper);
    }

    @Override
    public List<AccountBook> selectAll() {
        return accountBookMapper.selectList(null);
    }

}
