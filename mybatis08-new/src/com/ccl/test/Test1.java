package com.ccl.test;

import com.ccl.dao.StudentDao;
import com.ccl.domain.Student;
import com.ccl.util.SqlSessionUtil;
import com.ccl.vo.StudentAndClassVo;

import java.util.List;
import java.util.Map;

/**
 * Author 北京动力节点
 */
public class Test1 {

    public static void main(String[] args) {

        //select2之前使用的sqlsession
        //StudentService ss = (StudentService) ServiceFactory.getService(new StudentServiceImpl());

        //select2之后使用的sqlsession
        StudentDao ss = SqlSessionUtil.getSession().getMapper(StudentDao.class);


//        Student student = new Student();
//        student.setId(10);
//        student.setName("黄忠");
//        student.setEmail("huangzhong@qq.com");
//        student.setAge(56);

        //ss.save(student);

//        Student s = ss.getById(6);
//        System.out.println(s);

//        List<Student> sList = ss.getAll();
//
//        for (Student student : sList) {
//            System.out.println(student);
//        }

        //不能同时为SQL语句传递多个参数
//        List<Student>  studentList = ss.select1("黄忠",56);
//        for (Student student : studentList) {
//            System.out.println(student);
//        }

        //如果我要为sql语句传递多个参数，我们将这多个参数封装到一个domain对象，或打包到一个map
//        Student s = new Student();
//        s.setName("黄忠");
//        s.setAge(56);
//        List<Student> slist = ss.select2(s);
//        for (Student student : slist) {
//            System.out.println(student);
//        }

        //测试map
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("name","黄忠");
//        map.put("age",56);
//        List<Student> slist = ss.select3(map);
//        for (Student student : slist) {
//            System.out.println(student);
//        }
        /*
        总结
            在实际开发，使用domain，或者map集合类型都可以为sql语句都可以
            但简单的单表查询优先使用domain，在多表查询中，如果domain不符合，就使用map来传值

            查询 姓名为"za" 班级名为"终极一班"的学生信息

            select *
            form student s join class c on s.classId = c.id
            where s.name = #{name} and c.name=#{name};
         */




        /*
        like 模糊查询  重点
        方式1：使用${}了解
        方式二：使用#{}常用
         */

        //查询，like模糊查询，使用'${value}'
/*        List<Student> studentList = ss.select4("李");
        for (Student student : studentList) {
            System.out.println(student);
        }*/

//        like模糊查询，使用#{"%str%"} 不符合用户习惯，了解
       /* List<Student> studentList = ss.select5("李%");
        for (Student student : studentList) {
            System.out.println(student);
        }
*/

       //使用#{"str"} 掌握  %' #{name} '%'
     /*   List<Student> studentList = ss.select6("李");
        for (Student student : studentList) {
            System.out.println(student);
        }
*/
     /*
    测试查询resultType返回string类型对象

    */

        //查询年龄为56岁的学生的名字
//        String name = ss.select7(56);
//        System.out.println(name);


        //查询全部学生的名字
//        List<String> stringList = ss.select8();
//        for (String s : stringList) {
//            System.out.println(s);
//        }

        //int类型 查询表中由多少条信息
//        int count = ss.select9();
//        System.out.println("一共有"+count+"位学生。");

        //domain类型 查询刘备的全部信息
//        Student student = ss.select10("刘备");
//        System.out.println(student);

        //result 返回map集合
        /*
        查询原理：
            执行了sql语句之后，查询得到的结果
            根据返回值类型，会自动为我们创建一个该类型的对象，该对象将查询结果保存起来
            Map<String,Object> map1 = new HashMap<>();
            map1.put("id",1);
            map1.put("name",xxx);
            map1.put("email",XXx);
            map1.put("age",xxx);
            >>>>>>>>>>>>>>>>>>>>>>>>>>>>
            map2
            map3
            ...........
         */
//       List<Map<String,Object>> studentMap =  ss.select11();
//        for (Map<String, Object> map : studentMap) {
//            Set<String> set = map.keySet();
//            for (String key : set) {
//                System.out.println("key:"+key);
//                System.out.println("value:"+map.get(key));
//            }
//        }

        /*
        总结（domain和map该如何使用）
        domain查询比较方便易懂，一般情况下优先使用domain
        如果涉及到domain自身没有的属性，就应该考虑使用map
        例如查询叫刘备的学生有几个人？
        select count(*)
        from student
        group by name ="刘备"

        domain有name属性，但没有count属性，因此我们要使用map来保存查询这些结果

         */

        //但数据库字段名称和domain类属性名称不一致的处理(2种情况)
//        List<Student> studentList = ss.select12();
//        for (Student student : studentList) {
//            System.out.println(student);
//        }

        //测试 ：  动态sql  where标签结合if标签
//        Student student = new Student();
//        student.setAge(56);
//        student.setName("李");
//        List<Student> studentList = ss.select13(student);
//        for (Student student1 : studentList) {
//            System.out.println(student1);
//        }

        //前端往后端传递的是数组，后端往前端传的是集合
//        String arr[] = {"李白","黄忠"};
//        List<Student> studentList = ss.select14(arr);
//        for (Student student : studentList) {
//            System.out.println(student);
//        }

        //sql片段
//        Student student = new Student();
//        student.setName("黄忠");
//        Student stu = ss.select15(student);
//        System.out.println(stu);

        //多表联查
        //查询出学生名和班级名称
        List<Map<String,Object>> mapList = ss.select16();
        //方法一：
//        for (Map<String, Object> map : mapList) {
//            Set<String> keySet = map.keySet();
//            for (String key : keySet) {
//                System.out.println("key:"+key);
//                System.out.println("value:"+map.get(key));
//            }
//            System.out.println("---------------------------------");
//        }

        //方法二
//        for (Map<String, Object> map : mapList) {
//            System.out.println(map.values());
//        }
//

        //使用  vo(掌握)
//        List<StudentAndClassVo> voList = ss.select17();
//        for (StudentAndClassVo studentAndClassVo : voList) {
//            System.out.println(studentAndClassVo);
//        }

        //查询姓”李“的学生
//        List<StudentAndClassVo> voList = ss.select18("李");
//        for (StudentAndClassVo studentAndClassVo : voList) {
//            System.out.println(studentAndClassVo);
//        }

//        //查询姓”李“并且就读于二年一班的学生
//        StudentAndClassVo vo = new StudentAndClassVo();
//        vo.setSname("李");
//        vo.setCname("二年一班");
//        List<StudentAndClassVo> scvo = ss.select19(vo);
//        for (StudentAndClassVo studentAndClassVo : scvo) {
//            System.out.println(studentAndClassVo);
//        }

        //使用resultMap来搭配vo进行多表查询
        /*
            <resultMap id="stu" type="Student">
        <!--
        id标签： 用来匹配主键的对应关系
        result： 用来匹配普通字段的对应关系
        因此resultMap存在一个id 多个result

        property对应domain中的属性名
        column对应数据库中的字段名

        -->
        <id property="id" column="id"/>
        <result property="name" column="name"/>
        <result property="email" column="email"/>
        <result property="age" column="age"/>
    </resultMap>
         */
        StudentAndClassVo vo = new StudentAndClassVo();
        vo.setSname("刘");
        vo.setSage(54);
        List<StudentAndClassVo> voList = ss.select20(vo);
        for (StudentAndClassVo studentAndClassVo : voList) {
            System.out.println(studentAndClassVo);
        }




        /*
        在实际开发中，如果为前端同时提供多组值是，应该使用map还是使用vo
        如果前端需求的重复率不高，我们临时使用map就行
        如果前端使用率高，我们可以创建一个vo类来使用，非常方便

        阿龙理解：vo本质上和domain无区别，把数据库中的多个表中的字段名提取出来，
        解决了domain单表查询无法查询的难题，比map的写法简洁易懂，vo的字段名区分
        还依赖于数据库中的别名机制，一般来讲，数据库的别名要对应上vo中的属性值

         */

    }

}






























