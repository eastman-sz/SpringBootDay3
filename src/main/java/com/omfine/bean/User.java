package com.omfine.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
@Data
public class User extends BaseBean {

    public String name = null;
    public String image = null;
    @TableId
    public int uid = 0;

}
