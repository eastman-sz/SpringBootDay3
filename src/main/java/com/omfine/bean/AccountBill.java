package com.omfine.bean;

import lombok.Data;
@Data
public class AccountBill extends BaseBean{

    public int bookId = 0;
    public long billId = 0;
    public int amount = 0;
    public int primaryClassificationId = 0;
    public int secondaryClassificationId = 0;
    public int merchantId = 0;
    public long happenedTimeStamp = 0;
    public long cTime = 0;
    public String uniqueId = null;

}
