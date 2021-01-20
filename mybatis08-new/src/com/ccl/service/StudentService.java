package com.ccl.service;

import com.ccl.domain.Student;

import java.util.List;

public interface StudentService {
    public Student getById(Integer id);

    public void save(Student s);

    List<Student> getAll();

    List<Student> select2(Student s);
}
