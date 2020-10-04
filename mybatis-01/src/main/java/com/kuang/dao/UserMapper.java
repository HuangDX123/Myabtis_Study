package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> getUserLike(String s);

    //    查询全部用户
    List<User> getUserList();

    //    根据ID查询用户
    User getUserById(int id);

    //    添加用户
    int addUser(User user);

    //    万能的Map增加用户
    int addUser2(Map<String, Object> map);

    //    修改用户
    int updateUser(User user);

    //    删除用户
    int deleteUserById(int id);
}

