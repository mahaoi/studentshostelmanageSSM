package com.hao.dao;

import com.hao.domain.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/7 15:48
 */
@Repository
public interface LogDao {
    //用户名检测
    @Select("select * from student where username = #{username}")
    public Student testUserName(Student student);

    //登录用户查询
    @Select("select * from student where username = #{username} and password = #{password}")
    public Student findStudent(Student student);

    // 保存用户信息
    @Insert("insert into student (username,password,phone) values (#{username},#{password},#{phone})")
    public void saveStudent(Student student);
}
