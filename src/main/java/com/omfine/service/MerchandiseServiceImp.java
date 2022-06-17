package com.omfine.service;

import com.omfine.bean.Merchandise;
import com.omfine.mapper.MerchandiseMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class MerchandiseServiceImp implements MerchandiseService {

    @Resource
    private MerchandiseMapper merchandiseMapper = null;

    @Override
    public int insert(Merchandise merchandise) {
        return merchandiseMapper.insert(merchandise);
    }

    @Override
    public List<Merchandise> selectAll() {
        return merchandiseMapper.selectList(null);
    }


}
