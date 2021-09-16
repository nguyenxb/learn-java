package com.nguyenxb.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 工具类 : 获取 MyBatis的SqlSession对象
 */
public class MyBatisUtil {

    private static SqlSessionFactory factory = null;
    static {
        String config = "mybatis.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(config);
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param autoCommitFlag true:自动提交事务 , false: 手动提交事务
     * @return SqlSession对象
     */
    public static SqlSession getSqlSession(boolean autoCommitFlag){
        SqlSession sqlSession = null;
        if (factory != null){
            if (autoCommitFlag){
                sqlSession = factory.openSession(true);
            }else {
                sqlSession = factory.openSession();
            }
        }
        return sqlSession;
    }

    /**
     * @return 手工提交事务的SqlSession对象
     */
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        if (factory != null){
            sqlSession = factory.openSession();
        }
        return sqlSession;
    }
}
