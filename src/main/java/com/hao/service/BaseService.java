package com.hao.service;

import java.util.List;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/26 15:36
 */
public interface BaseService<T> {

    void delete(String id);

//    void update(T t);

//    T select(int id);

    int insert(T t);

    List<T> findAll();

}


