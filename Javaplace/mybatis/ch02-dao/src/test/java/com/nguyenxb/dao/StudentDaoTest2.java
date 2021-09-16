package com.nguyenxb.dao;

import com.nguyenxb.dao.Impl.StudentDaoImpl;
import com.nguyenxb.entity.Student;
import org.junit.Test;

import java.util.List;

public class StudentDaoTest2 {

    /*
     String sqlId = "com.nguyenxb.dao.StudentDao.selectStudentById";
     Student student = sqlSession.selectOne(sqlId, id);

     测试方法中: 调用dao的方法
    Student student = dao.selectStudentById(1001);

    (1) dao: 通过反射可以得到 全限定类型名称
     dao是StudentDao 类型的, 全限定名称 com.nguyenxb.dao.StudentDao
    (2) selectStudentById : dao中的方法名称, 方法名称就是 mapper 文件中标签的id
        通过dao.selectStudentById() 能得到 sqlId = "com.nguyenxb.dao.StudentDao.selectStudentById";
     (3) 如何确定调用SqlSession的哪个方法?
        1.根据dao接口的方法返回值,如果返回的是一个对象,例如Student,调用的是SqlSession.selectOne()
        如果dao 接口中的放啊返回List,调用SqlSession的selectList();

        2.根据mapper 文件中的标签,如果标签是<insert> , 调用SqlSession.insert()方法

    mybatis框架,发现使用dao的方法调用能确定执行sql语句的必要信息,所以mybatis简化了dao对象的实现.
        由mybatis 框架在程序执行期间,根据你的Dao接口, 创建一个内存中的接口实现类对象.
    mybatis 把这个技术叫做 代理技术 (动态代理, dao的动态代理).

        dao代理技术: 由mybatis创建StudentDao接口的实现类 StudentDaoImpl,
        使用框架创建的StudentDaoImpl 来代替手工实现的StudentDaoImpl 类的功能,
        就不需要开发人员写dao接口的实现类了

        而mybatis 实际上的创建XxxDao 接口的实现类是叫 Proxy ,上面只是举例说明

        使用 dao 的代理要求:
        1.mapper文件中的namespace : 必须使用dao接口的全限定名称
        2. mapper文件中标签的id 必须与 dao 接口中的方法名称一样

    * */

    @Test
    public void testSelectStudentById(){
        StudentDaoImpl dao = new StudentDaoImpl();
        Student student = dao.selectStudentById(1001);
        System.out.println(student.toString());
    }
    @Test
    public void testSelectStudents(){
        StudentDaoImpl dao = new StudentDaoImpl();
        List<Student> students = dao.selectStudents();
        // lambda 表达式
        students.forEach(student -> System.out.println(student.toString()));
    }
    @Test
    public void testInsertStudent(){
        StudentDaoImpl dao = new StudentDaoImpl();
        Student student = new Student();
        student.setId(1007);
        student.setName("阿萨");
        student.setEmail("as@qq.com");
        student.setAge(30);
        int rows = dao.insertStudent(student);
        System.out.println(rows);
    }
}
