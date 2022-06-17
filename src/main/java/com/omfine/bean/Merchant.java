package com.omfine.bean;

import lombok.Data;

@Data
public class Merchant extends BaseBean{

    public int merchantId = 0;
    public String name = null;
    public long cTime = 0;
}
