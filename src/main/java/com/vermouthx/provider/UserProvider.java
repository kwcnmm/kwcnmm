package com.vermouthx.provider;

import com.vermouthx.entity.User;

public class UserProvider {
    public String getUserProvider(User user) {
        return "SELECT * FROM users WHERE user_name = #{userName} AND user_password = #{userPassword}";
    }

    public String addUserProvider(User user) {
        return "INSERT INTO users (user_name,user_password) VALUES (#{userName},#{userPassword})";
    }

    public String updateUserScoreProvider(User user) {
        return "UPDATE users SET score = #{score} WHERE user_id = #{userId} AND score < #{score}";
    }
}
