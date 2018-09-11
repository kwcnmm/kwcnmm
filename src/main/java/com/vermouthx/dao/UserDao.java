package com.vermouthx.dao;

import com.vermouthx.entity.User;
import com.vermouthx.mapper.UserMapper;
import com.vermouthx.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.ResultSet;
import java.util.List;

public class UserDao {

    public List<User> getUser(User user) {
        SqlSession session = MybatisUtil.createSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> users = userMapper.getUser(user);
        session.close();
        return users;
    }

    public boolean addUser(User user) {
        boolean result = false;
        SqlSession session = MybatisUtil.createSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        try {
            userMapper.addUser(user);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return result;
    }

    public boolean updateUserScore(User user) {
        boolean result = false;
        SqlSession session = MybatisUtil.createSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        try {
            userMapper.updateUserScore(user);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return result;
    }
}
