package com.omfine.service;

import com.omfine.bean.AccountBook;

import java.util.List;

public interface AccountBookService {

    int insert(AccountBook accountBook);

    AccountBook getAccountBook(int uid , long cTime);

    List<AccountBook> selectAll();
}
