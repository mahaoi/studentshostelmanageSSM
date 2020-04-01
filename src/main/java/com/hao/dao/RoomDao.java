package com.hao.dao;

import com.hao.domain.RoomInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/16 16:36
 */
@Repository
public interface RoomDao {
    //查询所有
    @Select("select * from roominfo")
    List<RoomInfo> findAll();

    //删除宿舍
    @Delete("delete from roominfo where roomid = #{roomid}")
    void delRoom(String roomid);

    //修改
    @Update("update roominfo set roomin = ${roomIn} where roomid = #{roomid}")
    void update(@Param("roomid")String roomid,@Param("roomIn")String roomIn);
}
