package com.quchaoqun.services;

import com.quchaoqun.dao.StudentDao;
import com.quchaoqun.entity.Student;
import com.quchaoqun.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SelectService {
    public static void main(String[] args) {
       //使用Mybatis动态机制：获取Dao接口对象，调用对应的方法，对数据库进行操作
        //获取SqlSession对象
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        //学生全部信息查询
        List<Student> studentList=dao.findAll();
        studentList.forEach(student -> System.out.println(student));

        //单个信息查询
        Student s=dao.findSimple(1);
        System.out.println(s);

        //使用@Param命名参数，传入多个参数信息进行单个信息查询
        Student s1=dao.findSimple1("屈超群","湖南衡阳");
        System.out.println(s1);

        //使用Java对象进行传参，进行多个参数查询
        Student student=new Student();
        student.setName("饶磊");
        student.setEmail("湖南郴州");
        Student s2=dao.findSimple2(student);
        System.out.println(s2);
        //资源关闭
        sqlSession.close();

    }
}
