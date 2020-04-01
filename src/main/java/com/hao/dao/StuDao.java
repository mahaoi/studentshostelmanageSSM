package com.hao.dao;

import com.hao.domain.StudentInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/15 19:31
 */
@Repository
public interface StuDao {
    //查询所有
    @Select("select * from studentinfo")
    List<StudentInfo> findAll();

    //查询未分配宿舍学生
    @Select("select * from studentinfo where state=#{state}")
    List<StudentInfo> findByState(String state);

    //id学号查询
    @Select("select * from studentinfo where id=#{id}")
    List<StudentInfo> findById(String id);

    //姓名模糊查询
    @Select("select * from studentinfo where name=%#{name}%")
    List<StudentInfo> findByName(String name);

    //班级查询
    @Select("select * from studentinfo where name=%#{classes}%")
    List<StudentInfo> findByClass(String classes);

    //删除
    @Delete("delete from studentinfo where id = #{id}")
    void delById(String id);

    //更新学生状态
    @Update("update studentinfo set state = #{state} where id = #{id}")
    void upState(@Param("state") String state, @Param("id") String id);

}