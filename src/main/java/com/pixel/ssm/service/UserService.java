package com.pixel.ssm.service;

import com.pixel.ssm.dao.UserDao;
import com.pixel.ssm.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/11/21 0021.
 */
@Service("userService")
public class UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    public void saveUser(User user){
        userDao.addUser(user);
        System.out.print("保存完成");
    }

}
