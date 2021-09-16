package com.nguyenxb.service.impl;

import com.nguyenxb.dao.StudentDao;
import com.nguyenxb.entity.Student;
import com.nguyenxb.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    // 引用类型
    private StudentDao studentDao;

    // set注入赋值
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao=studentDao;
    }

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student) {
        int rows = studentDao.insertStudent(student);
        return rows;
    }

    @Override
    public List<Student> queryStudents() {
        List<Student> students = studentDao.selectStudents();
        return students;
    }
}
