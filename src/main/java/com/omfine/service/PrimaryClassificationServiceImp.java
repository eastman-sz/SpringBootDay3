package com.omfine.service;

import com.omfine.bean.PrimaryClassification;
import com.omfine.mapper.PrimaryClassificationMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class PrimaryClassificationServiceImp implements PrimaryClassificationService {

    @Resource
    private PrimaryClassificationMapper primaryClassificationMapper = null;

    @Override
    public int insert(PrimaryClassification primaryClassification) {
        return primaryClassificationMapper.insert(primaryClassification);
    }

    @Override
    public List<PrimaryClassification> selectList() {
        return primaryClassificationMapper.selectList(null);
    }

}
