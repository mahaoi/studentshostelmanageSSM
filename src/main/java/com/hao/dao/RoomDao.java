package com.hao.dao;

import com.hao.domain.RoomInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/16 16:36
 */
@Repository
public interface RoomDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from roominfo")
    List<RoomInfo> findAll();

    /**
     * 删除宿舍
     * @param roomid
     */
    @Delete("delete from roominfo where roomid = #{roomid}")
    void delRoom(String roomid);

    /**
     * 添加宿舍
     * @param roomInfo
     * @return
     */
    @Insert("insert into roominfo (roomid,roomin,password,remarks) values (#{roomid},${roomin},#{password},#{remarks})")
    int insert(RoomInfo roomInfo);

    /**
     * 修改
     * @param roomid
     * @param roomIn
     */
    @Update("update roominfo set roomin = ${roomIn} where roomid = #{roomid}")
    void update(@Param("roomid")String roomid,@Param("roomIn")String roomIn);

    /**
     * 登录用户查询
     * @param roomInfo
     * @return
     */
    @Select("select * from roominfo where roomid = #{roomid} and password = #{password}")
    RoomInfo findRoom(RoomInfo roomInfo);

    /**
     * 修改密码
     * @param roomid
     * @param password
     */
    @Update("update roominfo set password = #{password} where roomid = #{roomid}")
    void upPass(@Param("roomid")String roomid, @Param("password")String password);
}
