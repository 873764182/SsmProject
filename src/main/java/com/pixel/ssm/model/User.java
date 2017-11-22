package com.pixel.ssm.model;

/**
 * Created by Administrator on 2017/11/21 0021.
 */
public class User {
    /* 数据库ID */
    private int _id;
    /* 用户名称 */
    private String username;
    /* 用户密码 */
    private String password;
    /* 年龄 */
    private int age;

    public User() {
    }

    public User(int _id, String username, String password, int age) {
        this._id = _id;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
