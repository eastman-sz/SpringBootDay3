package com.omfine.controller;

import com.alibaba.fastjson.JSON;
import com.omfine.bean.FailedResultBean;
import com.omfine.bean.ResultBean;

public class BaseController {

    <T> String onSuccess(T data){
        ResultBean resultBean = new ResultBean();
        resultBean.setData(data);
        return JSON.toJSONString(resultBean);
    }

    String onFailed(String errorMsg){
        FailedResultBean resultBean = new FailedResultBean();
        resultBean.setMessage(errorMsg);
        return JSON.toJSONString(resultBean);
    }

}
