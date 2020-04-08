package com.hao.dao;

import com.hao.domain.Repair;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/4/2 16:35
 */
@Repository
public interface RepairDao {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from repair")
    List<Repair> findall();

    /**
     * 插入记录  返回受影响的记录行数
     * @param repair
     * @return
     */
    @Insert("insert into repair (repairName,repairTime,repairText,repairState) values (#{repairName},#{repairTime},#{repairText},#{repairState})")
    int insert(Repair repair);

    /**
     * 查询单个宿舍的报修记录
     * @param repairName
     * @return
     */
    @Select("select * from repair where repairName=#{repairName}")
    List<Repair> findByRoomId(String repairName);

    /**
     * 修改状态
     * @param repair
     */
    @Update("update repair set repairState = #{repairState},endTime=#{endTime} where repairId = ${repairId}")
    void upState(Repair repair);
}
