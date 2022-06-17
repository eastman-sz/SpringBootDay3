package com.omfine.bean;

import lombok.Data;

@Data
public class Merchandise extends BaseBean{

    public int merchandiseId = 0;
    public String name = null;
    public String image = null;
    public long cTime = 0;

}
