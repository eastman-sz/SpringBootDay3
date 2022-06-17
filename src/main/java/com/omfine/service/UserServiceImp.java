package com.omfine.service;

import com.omfine.bean.User;
import com.omfine.mapper.UserMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Resource
    private UserMapper mapper = null;

    @Override
    public int insert(User user) {
        return mapper.insert(user);
    }

    @Override
    public List<User> selectList() {
        return mapper.selectList(null);
    }

}
