package com.omfine.bean.out;

import com.omfine.bean.PrimaryClassification;
import com.omfine.bean.SecondaryClassification;
import lombok.Data;
import java.util.List;

@Data
public class ClassificationData {

    List<PrimaryClassification> primaryClassifications;
    List<SecondaryClassification> secondaryClassifications;

}
