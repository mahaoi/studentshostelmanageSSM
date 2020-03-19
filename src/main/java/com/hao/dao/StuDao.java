package com.hao.dao;

import com.hao.domain.StudentInfo;
import org.apache.ibatis.annotations.Delete;
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

    //id查询
    @Select("select * from studentinfo where id=#{id}")
    StudentInfo findById(String id);

    //删除
    @Delete("delete from studentinfo where id = #{id}")
    void delById(String id);

    //更新学生状态
    @Update("update studentinfo set state = #{state} where id = #{id}")
    void upState(String state,String id);
}
