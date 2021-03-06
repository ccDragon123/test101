package com.ccl.dao;

import com.ccl.pojo.User;
import com.ccl.utils.MybatisUtils;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class UserDaoTest {
    @Test
    public void test1(){
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //getMapper（）
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        for(User user:userList){
            System.out.println(user);
        }

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }
    @Test
    public void test2_1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Object> map = new HashMap<>();

        map.put("id",1);
        map.put("name","ccl");
        mapper.getUserById2(map);

        sqlSession.close();
    }

    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int result =  mapper.addUser(new User("翠花","242342",4));

        if (result > 0){
            sqlSession.commit();
        }

        sqlSession.close();
    }

    @Test
    public void test3_1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<>();

        map.put("userid",5);
        map.put("password","55454545");
        map.put("username","张全蛋");

        mapper.addUser2(map);

        sqlSession.commit();
        sqlSession.close();


    }
    @Test
    public void test4(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res1 = mapper.updateUser(new User("狗蛋", "goudan123", 4));

        if (res1>0){
            sqlSession.commit();
        }


        sqlSession.close();
    }

    @Test
    public void test5(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.deleteUser(4);
        System.out.println("结果为："+res);
        if (res>0){
            sqlSession.commit();
        }

        sqlSession.close();
    }

}
