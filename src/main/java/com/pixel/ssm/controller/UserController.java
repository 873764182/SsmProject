package com.pixel.ssm.controller;

import com.google.gson.Gson;
import com.pixel.ssm.dao.UserDao;
import com.pixel.ssm.model.User;
import com.pixel.ssm.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Random;

/**
 * Created by Administrator on 2017/11/21 0021.
 * <p/>
 * 用户控制器
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @ResponseBody()
    @RequestMapping(value = "/save/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String save(@PathVariable("username") String username) {
        User user = new User();
        user.set_id(new Random().nextInt());
        user.setUsername(username + "---" + System.currentTimeMillis());
        user.setPassword("123456");
        user.setAge(new Random().nextInt());
        userService.saveUser(user);

        System.out.print("添加完成");

        return new Gson().toJson(user);
    }

}
