package com.pixel.ssm.dao;

import com.pixel.ssm.model.User;

/**
 * Created by Administrator on 2017/11/21 0021.
 * <p/>
 * User Dao 接口
 */
public interface UserDao {

    public User getUser(User user);

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int UserId);

}
