package com.omfine.bean;

import lombok.Data;

@Data
public class AccountBook extends BaseBean {

    public int bookId = 0;
    public String name = null;
    public String image = null;
    public long cTime = 0;

}
