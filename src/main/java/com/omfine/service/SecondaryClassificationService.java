package com.omfine.service;

import com.omfine.bean.SecondaryClassification;
import java.util.List;

public interface SecondaryClassificationService {

    int insert(SecondaryClassification secondaryClassification);

    List<SecondaryClassification> selectList();
}
