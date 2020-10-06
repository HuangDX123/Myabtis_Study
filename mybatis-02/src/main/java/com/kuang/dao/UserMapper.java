package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;

public interface UserMapper {

    //    查询全部用户
    List<User> getUserList();

    //    模糊查询
    List<User> getUserLike(String s);

    //    添加用户
    int addUser(User user);

    //    修改用户
    int updateUser(User user);

    //    删除用户
    int deleteUserById(int id);
}

