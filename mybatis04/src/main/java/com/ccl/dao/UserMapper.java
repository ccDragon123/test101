package com.ccl.dao;

import com.ccl.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Select("select * from user")
    List<User> getUser();

    //方法存在多个参数，所有参数前面必须加上@param("id")注释
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Select("select * from user where pwd = #{password}")
    User getUserByPwd(@Param("password") String pwd);

    @Insert("insert into user(name,pwd,id) values (#{name},#{pwd},#{id})")
    int addUser(User user);


}
