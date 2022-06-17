package com.omfine.service;

import com.omfine.bean.AccountBill;

import java.util.List;

public interface AccountBillService {

    int insert(AccountBill accountBill);

    List<AccountBill> selectList();

    AccountBill selectOne(AccountBill accountBill);

    AccountBill selectOne( long billId);

    List<AccountBill> selectPage(int page , int rows);

    List<AccountBill> selectPage(int page , int rows , long startTimeStamp , long endTimeStamp);

    List<AccountBill> getAllBills();

}
