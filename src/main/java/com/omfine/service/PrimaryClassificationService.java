package com.omfine.service;

import com.omfine.bean.PrimaryClassification;

import java.util.List;

public interface PrimaryClassificationService {

    int insert(PrimaryClassification primaryClassification);

    List<PrimaryClassification> selectList();

}
