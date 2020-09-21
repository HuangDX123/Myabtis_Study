package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void test() {

//        第一步获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {

//       方式一：getMapper
//        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        List<User> userList = userDao.getUserList();
//       方式二：
            List<User> userList = sqlSession.selectList("com.kuang.dao.UserDao.getUserList");

            for (User user : userList) {
                System.out.println(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭SqlSession
            sqlSession.close();

        }


    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);
        System.out.println(user);

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

//        mapper.addUser(new User(10,"haha","zxz"));
//        抛出异常
        try {
            int res = mapper.addUser(new User(1, "小明", "中国"));
            if (res > 0) {
                System.out.println("插入成功！");
            } else {
                System.out.println("插入失败");
            }
//        提交事务
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("出现一个错误");
        }
        //关闭SqlSession
        sqlSession.close();

    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.updateUser(new User(1, "张三", "中国"));
        mapper.updateUser(new User(2, "李四", "中国"));
        mapper.updateUser(new User(3, "王五", "中国"));
        mapper.updateUser(new User(4, "Brian", "US"));
        if (res > 0) {
            System.out.println("修改成功！");
        } else {
            System.out.println("修改失败");
        }
//        提交事务
        sqlSession.commit();
        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void deletUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.deleteUserById(5);

        if (res > 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败");
        }
//        提交事务
        sqlSession.commit();
        //关闭SqlSession
        sqlSession.close();

    }

}
