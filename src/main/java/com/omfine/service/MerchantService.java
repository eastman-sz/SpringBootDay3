package com.omfine.service;

import com.omfine.bean.Merchant;

import java.util.List;

public interface MerchantService {

    int insert(Merchant merchant);

    List<Merchant> selectList();

}
