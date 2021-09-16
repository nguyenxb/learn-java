package com.nguyenxb.dao;

import com.nguyenxb.entity.Student;
import com.nguyenxb.pojo.CustomObject;
import com.nguyenxb.pojo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    // if 使用动态sql 时, 参数使用对象
    List<Student> selectIf(Student student);
    // where 标签
    List<Student> selectWhere(Student student);
    // 使用foreach 第一种方式
    List<Student> selectForeach1(List<Integer> idList);

    // 使用foreach 第二种方式
    List<Student> selectForeach2(List<Student> studentList);

    // pageHelper 用法
    List<Student> selectAllStudents();

}
