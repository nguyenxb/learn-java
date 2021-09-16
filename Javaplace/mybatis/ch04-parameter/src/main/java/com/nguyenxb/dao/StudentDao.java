package com.nguyenxb.dao;

import com.nguyenxb.entity.Student;
import com.nguyenxb.pojo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    // 根据id 查询一个学生
    Student selectStudentById(Integer id);

    // 根据email 查询一个学生
    Student selectByEmail(String email);

    /*
    * 多个简单类型的参数
    * 使用 @Param 命名参数, 注解是mybatis提供的
    * 位置: 在形参定义的前面
    * 属性:value 自定义的参数名称
    * 基本语法格式 :
    * @Param(value="myname") 参数
    * 当然也可以省略value 即 @Param("myname")
    *
    * */
    List<Student> selectByNameOrAge(@Param(value = "myname") String name,
                                    @Param("myage") Integer age);

    /*
    * 一个java对象作为参数(对应由属性,每个属性有set,get方法)
    * */
    List<Student> selectByObject(Student student);

    List<Student> selectByObject2(QueryParam param);

    List<Student> selectByPosition(String name,Integer age);

    /*
    * 使用map作为参数
    * */

    List<Student> selectStudentByMap(Map<String,Object> map);

    // ${} 占位符的使用
    List<Student> queryStudent(@Param("studentName") String name);

    // ${} 占位符的使用: 操作列名
    List<Student> queryStudentByColName(@Param("colName") String name);

    // ${} 占位符的使用: 操作列名
    List<Student> queryStudents(
            @Param("tableName")String tableName,
            @Param("name") String name,
            @Param("colName") String colName);

}
