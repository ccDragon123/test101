package com.ccl.dao;

import com.ccl.pojo.User;
import com.ccl.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserDaoTest {
    static Logger logger = Logger.getLogger(UserDaoTest.class);

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


    @Test
    public void testLog4j(){
        logger.info("info:进入log4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了log4j");
    }

    @Test
    public void testLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int currentPage = 1;  //第几页
        int pageSize = 2;  //每页显示几个
        HashMap<String, Integer> map = new HashMap<>();
//        map.put("startPage",(currentPage-1)*pageSize);
//        map.put("pageSize",pageSize);
        map.put("startPage",0);
        map.put("pageSize",4);

        List<User> userList = mapper.getUserByLimit(map);
        for (User user:userList){
            System.out.println(user);
        }

        sqlSession.close();

    }

    //分页查询 , 两个参数startIndex , pageSize
    @Test
    public void testSelectUser() {
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        int currentPage = 1;  //第几页
        int pageSize = 2;  //每页显示几个
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("startPage",0);
        map.put("pageSize",pageSize);

        List<User> userList = mapper.getUserByLimit(map);

        for (User user: userList){
            System.out.println(user);
        }

        session.close();
    }
}
