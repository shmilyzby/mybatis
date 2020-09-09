package com.kuang.dao;

import com.kuang.pojo.Student;

import java.util.List;

public interface StudentMapper {

    //查询所有的学生信息以及对应的老师信息
    public List<Student> getStudent();
    public List<Student> getStudent2();

}


