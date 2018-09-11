package com.vermouthx.util;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import com.vermouthx.entity.User;
import com.vermouthx.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    public MybatisUtil() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSession createSession() {
        return sqlSessionFactory.openSession();
    }

}
