package com.pixel.ssm.dao;

import com.pixel.ssm.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/11/21 0021.
 */
@Deprecated
@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {
    @Override
    public User getUser(User user) {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(int UserId) {

    }
}
