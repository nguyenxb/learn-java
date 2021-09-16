package com.nguyen.service.impl;

import com.nguyen.dao.StudentDao;
import com.nguyen.domain.Student;
import com.nguyen.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    /**
     * dao是引用类型,StudentDao类型的对象是在Spring的配置文件中创建的对象,
     * 引用类型自动注入 @Autowired, @Resource
     * */
    @Autowired
    private StudentDao dao;
    @Override
    public int addStudent(Student student) {
        int rows = dao.insertStudent(student);
        return rows;
    }

    @Override
    public List<Student> queryStudents() {
        List<Student> students = dao.selectStudents();
        return students;
    }
}
