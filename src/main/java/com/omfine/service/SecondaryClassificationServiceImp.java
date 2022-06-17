package com.omfine.service;

import com.omfine.bean.SecondaryClassification;
import com.omfine.mapper.SecondaryClassificationMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class SecondaryClassificationServiceImp implements SecondaryClassificationService {

    @Resource
    private SecondaryClassificationMapper secondaryClassificationMapper = null;

    @Override
    public int insert(SecondaryClassification secondaryClassification) {
        return secondaryClassificationMapper.insert(secondaryClassification);
    }

    @Override
    public List<SecondaryClassification> selectList() {
        return secondaryClassificationMapper.selectList(null);
    }


}
