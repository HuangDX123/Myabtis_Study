package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

public class UserDaoTest {

    @Test
    public void test(){

//        第一步获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {

//       方式一：getMapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();
//       方式二：
//            List<User> userList = sqlSession.selectList("com.kuang.dao.UserDao.getUserList");

            for (User user : userList){
                System.out.println(user);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭SqlSession
            sqlSession.close();

        }


    }
}
