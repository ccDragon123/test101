package com.ccl.dao;

import com.ccl.domain.Student;
import com.ccl.vo.StudentAndClassVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StudentDao {


    public Student getById(Integer id);

    public void save(Student s);

    List<Student> getAll();

    List<Student> select2(Student s);

    List<Student> select3(HashMap<String, Object> map);

     List<Student> select4(String str);

    List<Student> select5(String string);

    List<Student> select6(String string);

    String select7(int i);

    List<String> select8();

    int select9();

    Student select10(String name);

    List<Map<String, Object>> select11();

    List<Student> select12();

    List<Student> select13(Student student);

    List<Student> select14(String[] arr);

    Student select15(Student student);

    List<Map<String, Object>> select16();

    List<StudentAndClassVo> select17();

    List<StudentAndClassVo> select19(StudentAndClassVo vo);

    List<StudentAndClassVo> select18(String str);

    List<StudentAndClassVo> select20(StudentAndClassVo vo);

}
