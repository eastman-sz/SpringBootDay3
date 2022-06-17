package com.omfine.controller;

import com.alibaba.fastjson.JSON;
import com.omfine.bean.ResultBean;
import com.omfine.bean.User;
import com.omfine.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Resource
    public UserService userService = null;

    @RequestMapping("/in")
    public String insert(Model model){
        User user = new User();
        user.name = "Name003";
        int result = userService.insert(user);
        System.err.println("================insert==result: " + result);
        String msg = 1 == result ? "添加成功" : "添加失败";
        model.addAttribute("result" , msg);
        return "result";
    }

    @RequestMapping("/getUsers")
    @ResponseBody
    public String getUsers(){
        List<User> users = userService.selectList();

        ResultBean resultBean = new ResultBean();
        resultBean.setData(users);
        String jsonData = JSON.toJSONString(resultBean);

        System.err.println("================getUsers==result: " + jsonData);
        return jsonData;
    }


}
