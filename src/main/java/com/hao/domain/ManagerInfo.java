package com.hao.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/4/1 16:19
 */
@Data
public class ManagerInfo implements Serializable {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
