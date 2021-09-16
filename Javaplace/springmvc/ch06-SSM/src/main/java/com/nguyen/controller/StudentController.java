package com.nguyen.controller;

import com.nguyen.domain.Student;
import com.nguyen.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    // 添加学生
    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student){
        ModelAndView modelAndView = new ModelAndView();

        // 调用service, 处理业务逻辑,把处理结果返回给用户
        int rows = studentService.addStudent(student);
        String msg = "注册失败!!!";
        if (rows > 0){
            // 注册成功,给用户成功的数据和视图
            msg = "注册成功的";
        }
        modelAndView.addObject("msg",student.getName()+":"+student.getAge()+","+msg);
        modelAndView.setViewName("result");
        return modelAndView;
    }

    @RequestMapping(value = "/queryStudents.do")
    @ResponseBody
    public List<Student> queryStudents(){
        List<Student> list = studentService.queryStudents();
        return list;
    }

}
