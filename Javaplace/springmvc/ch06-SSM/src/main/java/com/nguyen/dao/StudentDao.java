package com.nguyen.dao;

import com.nguyen.domain.Student;

import java.util.List;

public interface StudentDao {
    int insertStudent(Student student);

    List<Student> selectStudents();

}
