package com.nguyen.service;

import com.nguyen.dao.StudentDao;
import com.nguyen.domain.Student;

import java.util.List;

public interface StudentService {
    int addStudent(Student student);

    List<Student> queryStudents();
}
