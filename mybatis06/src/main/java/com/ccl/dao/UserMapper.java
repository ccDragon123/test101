package com.ccl.dao;

import com.ccl.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> queryUserId(@Param("id") int id);

    int updateUser(Map map);


}
