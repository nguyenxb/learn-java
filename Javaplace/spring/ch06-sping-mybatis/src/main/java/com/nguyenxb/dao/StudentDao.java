package com.nguyenxb.dao;

import com.nguyenxb.entity.Student;

import java.util.List;

public interface StudentDao {
    int insertStudent(Student student);
    List<Student> selectStudents();
}
