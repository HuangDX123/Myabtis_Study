package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    //    模糊查询
    @Test
    public void getUserLisk() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }
        //关闭SqlSession
        sqlSession.close();

    }

//
//
//    //查询全部数据
//    @Test
//    public void test() {
//        //第一步获取sqlSession对象
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//
//        try {
//            //方式一：getMapper
//            UserMapper userDao = sqlSession.getMapper(UserMapper.class);
//            List<User> userList = userDao.getUserList();
//            //方式二：
//            //List<User> userList = sqlSession.selectList("com.kuang.dao.UserDao.getUserList");
//            for (User user : userList) {
//                System.out.println(user);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            //关闭SqlSession
//            sqlSession.close();
//        }
//    }
//
//
//    //插入数据
//    @Test
//    public void addUser() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//
//        //mapper.addUser(new User(10,"haha","zxz"));
//        //抛出异常
//        try {
//            int res = mapper.addUser(new User(1, "小明", "中国"));
//            if (res > 0) {
//                System.out.println("插入成功！");
//            } else {
//                System.out.println("插入失败");
//            }
//            //提交事务
//            sqlSession.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("出现一个错误");
//        }
//        //关闭SqlSession
//        sqlSession.close();
//
//    }
//
//    //Map插入数据
//    @Test
//    public void addUser2() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//
//        Map<String, Object> map = new HashMap<String, Object>();
//
//        map.put("userid", 8);
//        map.put("username", "老王");
//        map.put("userpwd", "中国");
//
//
//        int res = mapper.addUser2(map);
//        if (res > 0) {
//            System.out.println(map);
//            System.out.println("插入成功！");
//        } else {
//            System.out.println(map);
//            System.out.println("插入失败");
//        }
//
//        //提交事务
//        sqlSession.commit();
//        //关闭SqlSession
//        sqlSession.close();
//
//    }
//
//
//    //修改数据
//    @Test
//    public void updateUser() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//
//        int res = mapper.updateUser(new User(7, "张三", "德国"));
//
//        if (res > 0) {
//            System.out.println("修改成功！");
//        } else {
//            System.out.println("修改失败");
//        }
//        //提交事务
//        sqlSession.commit();
//        //关闭SqlSession
//        sqlSession.close();
//    }
//
//    //删除数据
//    @Test
//    public void deletUserById() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//
//        int res = mapper.deleteUserById(8);
//
//        if (res > 0) {
//            System.out.println("删除成功！");
//        } else {
//            System.out.println("删除失败");
//        }
////        提交事务
//        sqlSession.commit();
//        //关闭SqlSession
//        sqlSession.close();
//
//    }

}
