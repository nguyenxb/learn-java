package com.nguyenxb.dao.Impl;

import com.nguyenxb.dao.StudentDao;
import com.nguyenxb.entity.Student;
import com.nguyenxb.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public Student selectStudentById(Integer id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String sqlId = "com.nguyenxb.dao.StudentDao.selectStudentById";
        Student student = sqlSession.selectOne(sqlId, id);
        sqlSession.close();
        return student;
    }

    @Override
    public List<Student> selectStudents() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String sqlId = "com.nguyenxb.dao.StudentDao.selectStudents";
        List<Student> students = sqlSession.selectList(sqlId);
        sqlSession.close();
        return students;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String sqlId = "com.nguyenxb.dao.StudentDao.insertStudent";
        int rows = sqlSession.insert(sqlId, student);
        sqlSession.commit();
        sqlSession.close();
        return rows;
    }
}
