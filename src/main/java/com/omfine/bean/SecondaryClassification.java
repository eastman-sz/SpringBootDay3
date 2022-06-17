package com.omfine.bean;

import lombok.Data;
@Data
public class SecondaryClassification extends BaseBean {

    public int cid = 0;
    /**
     * 上级分类。
     */
    public int pid = 0;
    public String name = null;

}
