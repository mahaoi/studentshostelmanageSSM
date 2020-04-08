package com.hao.dao;

import com.hao.domain.VisitorInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/30 12:45
 */
public interface VisitDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from visitorinfo")
    List<VisitorInfo> findAll();

    /**
     * 插入记录  返回受影响的记录行数
     * @param visitor
     * @return
     */
    @Insert("insert into visitorinfo (visitName,visitPhone,visitTime,visitRemarks) values (#{visitName},#{visitPhone},#{visitTime},#{visitRemarks})")
    int insert(VisitorInfo visitor);
}
