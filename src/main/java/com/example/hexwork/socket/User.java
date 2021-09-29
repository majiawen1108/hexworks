package com.example.hexwork.socket;

import lombok.Data;

/**
 * @author jw.ma
 * @title: User
 * @description: TODO
 * @date 2021/9/29 10:36
 */
@Data
public class User {
    private String password;
    private String username;

    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }
}
