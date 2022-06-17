package com.omfine.service;

import com.omfine.bean.Merchant;
import com.omfine.mapper.MerchantMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class MerchantServiceImp implements MerchantService {

    @Resource
    private MerchantMapper merchantMapper = null;

    @Override
    public int insert(Merchant merchant) {
        return merchantMapper.insert(merchant);
    }

    @Override
    public List<Merchant> selectList() {
        return merchantMapper.selectList(null);
    }


}
