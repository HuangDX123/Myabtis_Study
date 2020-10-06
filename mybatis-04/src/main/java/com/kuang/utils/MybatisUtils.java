package com.kuang.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//工具类

//sqlSessionFactory --> sqlSession
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //使用Mybatis 第一步获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //既然有了SQLSessionFactory,顺名思义，我们就可以从中获取得到sqlSession的实例
    //SqlSession 完全包含了面向数据库执行SQL命令所需要的所有方法

    //public static SqlSession getSqlSession(){
    // return sqlSessionFactory.openSession();
    //}
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
