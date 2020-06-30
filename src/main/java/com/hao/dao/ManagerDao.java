package com.hao.dao;

import com.hao.domain.ManagerInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/4/1 16:24
 */
@Repository
public interface ManagerDao {
    /**
     * 用户名检测
     * @param managerInfo
     * @return
     */
    @Select("select * from managerinfo where username = #{username}")
    ManagerInfo testOldPass(ManagerInfo managerInfo);

    /**
     * 登录用户查询
     * @param managerInfo
     * @return
     */
    @Select("select * from managerinfo where username = #{username} and password = #{password} limit 1")
    ManagerInfo findManager(ManagerInfo managerInfo);

    /**
     * 保存用户信息
     * @param managerInfo
     */
    @Insert("insert into managerinfo (username,password) values (#{username},#{password})")
    int insert(ManagerInfo managerInfo);

    /**
     * 修改密码
     * @param username
     * @param password
     */
    @Update("update managerinfo set password = #{password} where username = #{username}")
    void update(@Param("username")String username, @Param("password")String password);

    /**
     * 删除管理员
     * @param username
     */
    @Delete("delete from managerinfo where username = #{username}")
    void delete(String username);


    /**
     * 查询所有manager
     * @return
     */
    @Select("select * from managerinfo")
    List<ManagerInfo> findAll();
}
