package com.nguyenxb.dao;

import com.nguyenxb.entity.Student;
import com.nguyenxb.pojo.CustomObject;
import com.nguyenxb.pojo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    // 根据id 查询一个学生
    Student selectStudentById(Integer id);

    CustomObject selectCustomObjectById(@Param("stuid") Integer id);
    CustomObject selectCustomObjectById2(@Param("stuid") Integer id);

    // 获取 表中 有行数据
    long countStudent();

    // 查询结果返回一个Map结构数据
    Map<Object,Object> selectMap(@Param("stuid")  Integer id);

    // like第一种方式
    List<Student> selectLikeOne(@Param("name") String name);
    // like第二种方式
    List<Student> selectLikeTwo(@Param("name") String name);
}
