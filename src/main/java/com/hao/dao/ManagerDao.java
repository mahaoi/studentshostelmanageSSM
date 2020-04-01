package com.hao.dao;

import com.hao.domain.ManagerInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/4/1 16:24
 */
@Repository
public interface ManagerDao {
    //用户名检测
    @Select("select * from managerinfo where username = #{username}")
    ManagerInfo testUserName(ManagerInfo managerInfo);

    //登录用户查询
    @Select("select * from managerinfo where username = #{username} and password = #{password}")
    ManagerInfo findManager(ManagerInfo managerInfo);

    // 保存用户信息
    @Insert("insert into managerinfo (username,password) values (#{username},#{password})")
    void saveManager(ManagerInfo managerInfo);
}
