package com.quchaoqun.dao;

import com.quchaoqun.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    //所有学生信息查询
    List<Student> findAll();
    //单个学生信息查询，传参：学生编号
    Student findSimple(Integer id);
    //单个学生信息查询，使用@Param命名参数，传多个参数给Mapper文件：
    // 参数：学生姓名+邮箱地址
    Student findSimple1(@Param("myName") String name, @Param("myEmail") String email);

    //单个学生信息查询，使用java对象进行传入参数，传多个参数给Mapper文件：
    // 参数
    Student findSimple2(Student student);

    //学生信息插入
    int insertStu(Student student);
}