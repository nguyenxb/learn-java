package com.nguyenxb.dao;

import com.nguyenxb.entity.Student;

public interface StudentDao {
    // 查询一个学生
    Student selectStudentById(Integer id);

    /**
     * @param student 学生对象
     * @return 返回本次操作数据库影响的行数
     */
    // 添加学生
    int insertStudent(Student student);
}
