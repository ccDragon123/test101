package com.ccl.test;


import com.ccl.init.initLogRecord;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author 北京动力节点
 */
public class Test1 {

    public static void main(String[] args) {
//        initLogRecord.initLog();

        String resource = "mybatis-config.xml";
        //输入流
        InputStream inputStream = null;
        try {
            //通过加载MyBatis的主配置文件mybatis-config.xml，创建输入流对象
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*

            SqlSessionFactoryBuilder:SqlSessionFactory的建造者
                通过该建造者对象调用建造方法，为我们创建一个SqlSessionFactory对象

            sqlSessionFactory对象唯一的作用就是为我们创建SqlSession对象


         */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //我们未来所有的操作，使用的都是SqlSession对象session来完成
        //例如增删改查，处理事务等等，都是统一使用session对象来完成
        SqlSession session = sqlSessionFactory.openSession();

        /*

            需求：根据id查单条

                如果取得的是单条记录，我们调用selectOne方法
                参数1：根据命名空间.sqlId的形式找到我们需要使用的sql语句
                参数2：我们要为sql语句中传递的参数

         */
        /*Student s = session.selectOne("test1.getById", "A0001");
        System.out.println(s);
        session.close();*/

        //查询学生信息表中所有的记录
        /*List<Student> sList = session.selectList("test1.getAll");
        for(Student s:sList){
            System.out.println(s);
        }
        session.close();*/

        /*

            MyBatis默认情况下是手动提交事务

         */
        //添加操作
        /*Student s = new Student();
        s.setId("A0006");
        s.setName("cxk");
        s.setAge(23);
        session.insert("test1.save", s);
        session.commit();
        session.close();*/

        //修改操作
        /*Student s = new Student();
        s.setId("A0006");
        s.setName("cxk1");
        s.setAge(24);
        session.update("test1.update", s);
        session.commit();
        session.close();*/

        //单人查询
//        Student s = session.selectOne("test1.getById", "1")；

        //查询全部
//        List<Student> slist = session.selectList("getAll");
//        for (Student student : slist) {
//            System.out.println(student);
//        }

        //插入数据
//        Student student = new Student(56,"张良","zhangliang@qq.com",34);
//        int i = session.insert("save", student);
//        if (i > 0){
//            System.out.println("成功插入"+i+"条数据");
//        }else {
//            System.out.println("插入失败！");
//        }

        //修改
//        Student student = new Student(56,"张良2","zhangliang@qq.com",34);
//        session.update("update",student);

        //删除一条数据
        session.delete("delete",56);

        session.commit();

        session.close();

    }

}






























