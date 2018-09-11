package com.vermouthx.mapper;

import com.vermouthx.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Results(id = "userMap", value = {
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userPassword", column = "user_password"),
            @Result(property = "score", column = "score")
    })
    @Select("SELECT * FROM user WHERE user_name = #{user.userName} AND user_password = #{user.userPassword}")
    List<User> getUser(User user);

    @Insert("INSERT INTO user (user_name,user_password) VALUES (#{user.userName},#{user.userPassword})")
    void addUser(User user);

    @Update("UPDATE user SET score = #{user.score} WHERE user_id = #{user.userId} AND score < #{user.score}")
    void updateUserScore(User user);
}
