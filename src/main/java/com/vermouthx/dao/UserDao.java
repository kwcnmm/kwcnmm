package com.vermouthx.dao;

import com.vermouthx.entity.User;
import com.vermouthx.mapper.UserMapper;
import com.vermouthx.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDao {
    MybatisUtil mybatisUtil = new MybatisUtil();

    public List<User> getUser(User user) {
        SqlSession session = mybatisUtil.createSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> users = userMapper.getUser(user);
        session.close();
        return users;
    }

    public boolean addUser(User user) {
        SqlSession session = mybatisUtil.createSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        int result = userMapper.addUser(user);
        session.close();
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updateUserScore(User user) {
        SqlSession session = mybatisUtil.createSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        int result = userMapper.updateUserScore(user);
        session.close();
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }
}
