package com.nguyenxb.ba06;

public class Student {
    private String name;
    private int age;

    // 声明一个引用类型
    private School school;

    public Student(String myname, int myage, School myschool) {
        this.name = myname;
        this.age = myage;
        this.school = myschool;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
