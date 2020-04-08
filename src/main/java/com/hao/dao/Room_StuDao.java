package com.hao.dao;

import com.hao.domain.Room_Stu;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/16 21:22
 */
@Repository
public interface Room_StuDao {

    /**
     * 查询已入住
     * @param roomid
     * @return
     */
    @Select("select * from room_stu where roomid=#{roomid}")
    @Results({
            @Result(id = true,column = "rsid",property = "rsid"),
            @Result(column = "roomid",property = "roomid"),
            @Result(column = "id",property = "id"),
            @Result(property="studentInfos",column="id",
                    many=@Many(select="com.hao.dao.StuDao.findById",fetchType = FetchType.LAZY))
    })
    List<Room_Stu> findByRoomid(String roomid);

    /**
     * 每个宿舍已入住人数
     * @param roomid
     * @return
     */
    @Select("select count(*) from room_stu where roomid=#{roomid}")
    Integer stuCount(String roomid);

    /**
     * 查询宿舍号
     * @param id
     * @return
     */
    @Select("select roomid from room_stu where id=#{id}")
    String findRoomidById(String id);

    /**
     * 移除学生
     * @param id
     */
    @Delete("delete from room_stu where id=#{id}")
    void delete(String id);

    /**
     * 查询宿舍学生学号
     * @param roomId
     * @return
     */
    @Select("SELECT id FROM room_stu WHERE roomid=#{roomId}")
    List<Room_Stu> findIdList(String roomId);

    /**
     * 插入记录
     * @param room_stu
     * @return
     */
    @Insert("insert into room_stu (roomid,id) values (#{roomid},#{id})")
    int insert(Room_Stu room_stu);

    /**
     * 修改
     * @param roomid
     * @param id
     */
    @Update("update room_stu set roomid = #{roomid} where id = #{id}")
    void update(@Param("roomid")String roomid,@Param("id")String id);
}
