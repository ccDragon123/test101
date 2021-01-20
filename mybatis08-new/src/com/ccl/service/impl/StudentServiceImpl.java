package com.ccl.service.impl;

import com.ccl.dao.StudentDao;
import com.ccl.domain.Student;
import com.ccl.service.StudentService;
import com.ccl.util.SqlSessionUtil;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = SqlSessionUtil.getSession().getMapper(StudentDao.class);

    @Override
    public Student getById(Integer id) {
        Student s = studentDao.getById(id);

        return s;
    }

    @Override
    public void save(Student s) {

        studentDao.save(s);

    }

    @Override
    public List<Student> getAll() {
        List<Student> sList = studentDao.getAll();
        return sList;
    }

    @Override
    public List<Student> select2(Student s) {
        List<Student> studentList = studentDao.select2(s);
        return  studentList;
    }

}
