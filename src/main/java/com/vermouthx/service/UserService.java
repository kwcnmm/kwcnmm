package com.vermouthx.service;

import com.vermouthx.dao.UserDao;
import com.vermouthx.entity.User;
import com.vermouthx.exception.UserException;

import java.util.List;
import java.util.regex.Pattern;

public class UserService{
    private UserDao userDao = new UserDao();
    List<User> users;

    /*
     *注册功能
     */
    public boolean register(User user) throws UserException {
        String userName = user.getUserName();
        String userPassword = user.getUserPassword();

        String userNameRegex = "^[\u4e00-\u9fa5]{0,10}$";
        String userPasswordRegex = "^[a-zA-Z]\\w{5,17}$";

        boolean userNameIsRight = Pattern.matches(userNameRegex, userName);
        boolean userPasswordIsRight = Pattern.matches(userPasswordRegex,
                userPassword);
        boolean result = false;
        if (userNameIsRight && userPasswordIsRight) {
            result = userDao.addUser(user);
        } else if (userNameIsRight == false) {
            throw new UserException("用户名格式错误");
        } else if (userPasswordIsRight == false) {
            throw new UserException("密码格式错误");
        }
        return result;
    }

    /*
     *登录功能
     */
    public List<User> login(User user) throws UserException {
        String userNameRegex = "^[\u4e00-\u9fa5]{0,10}$";
        String userPasswordRegex = "^[a-zA-Z]\\w{5,17}$";

        boolean userNameIsRight = Pattern.matches(userNameRegex, user.getUserName());
        boolean userPasswordIsRight = Pattern.matches(userPasswordRegex,
                user.getUserPassword());

        if (userNameIsRight && userPasswordIsRight) {
            users = userDao.getUser(user);
        } else if (userNameIsRight == false) {
            throw new UserException("用户名格式错误");
        } else if (userPasswordIsRight == false) {
            throw new UserException("密码格式错误");
        }
        return users;
    }

    /*
     *更新成绩功能
     */
    public boolean updateScore(User user) {
        return userDao.updateUserScore(user);
    }
}
