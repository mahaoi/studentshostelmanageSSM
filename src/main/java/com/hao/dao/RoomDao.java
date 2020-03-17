package com.hao.dao;

import com.hao.domain.RoomInfo;
import org.apache.ibatis.annotations.Select;
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


}
