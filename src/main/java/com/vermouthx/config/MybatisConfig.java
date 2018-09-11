package com.vermouthx.config;

import com.vermouthx.entity.User;
import com.vermouthx.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.InputStream;

public class MybatisConfig {
    private SqlSession session;
    public UserMapper userMapper;
    public MybatisConfig() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        userMapper = session.getMapper(UserMapper.class);
    }
    public void sessionClose(){
        session.close();
    }
}
