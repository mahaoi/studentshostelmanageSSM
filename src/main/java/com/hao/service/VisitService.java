package com.hao.service;

import com.hao.domain.VisitorInfo;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/30 12:47
 */
public interface VisitService extends BaseService<VisitorInfo>{
    //插入记录  返回受影响的记录行数
    int insert(VisitorInfo visitor);
}
