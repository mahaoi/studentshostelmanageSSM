package com.hao.dao;

import com.hao.domain.StudentInfo;
import com.hao.domain.VisitorInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/15 19:31
 */
@Repository
public interface StuDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from studentinfo")
    List<StudentInfo> findAll();

    /**
     * 查询未分配宿舍学生
     * @param state
     * @return
     */
    @Select("select * from studentinfo where state=#{state}")
    List<StudentInfo> findByState(String state);

    /**
     * id学号查询
     * @param id
     * @return
     */
    @Select("select * from studentinfo where id=#{id}")
    List<StudentInfo> findById(String id);

    /**
     * 姓名模糊查询
     * @param name
     * @return
     */
    @Select("select * from studentinfo where name=%#{name}%")
    List<StudentInfo> findByName(String name);

    /**
     * 班级查询
     * @param classes
     * @return
     */
    @Select("select * from studentinfo where name=%#{classes}%")
    List<StudentInfo> findByClass(String classes);

    /**
     * 删除
     * @param id
     */
    @Delete("delete from studentinfo where id = #{id}")
    void delById(String id);

    /**
     * 更新学生状态
     * @param state
     * @param id
     */
    @Update("update studentinfo set state = #{state} where id = #{id}")
    void upState(@Param("state") String state, @Param("id") String id);

    /**
     * 插入记录  返回受影响的记录行数
     * @param studentInfo
     * @return
     */
    @Insert("insert into studentinfo (id,name,sex,major,classes,phone,state) values (#{id},#{name},#{sex},#{major},#{classes},#{phone},#{state})")
    int insert(StudentInfo studentInfo);

}
