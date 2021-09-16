package com.nguyenxb.service;

import com.nguyenxb.entity.Student;

import java.util.List;

public interface StudentService {
    int addStudent(Student student);

    List<Student> queryStudents();
}
