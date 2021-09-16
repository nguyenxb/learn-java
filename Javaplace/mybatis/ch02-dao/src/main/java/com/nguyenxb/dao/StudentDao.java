package com.nguyenxb.dao;

import com.nguyenxb.entity.Student;

import java.util.List;

public interface StudentDao {
    // 根据id 查询一个学生
    Student selectStudentById(Integer id);

    // 查询所有学生
    List<Student> selectStudents();

    // 添加学生
    int insertStudent(Student student);
}
