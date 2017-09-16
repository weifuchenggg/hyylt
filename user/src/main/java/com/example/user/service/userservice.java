package com.example.user.service;

import com.example.user.pojo.User;

import java.util.List;

public interface userservice {
    public List<User> userlogin(String userid, String userpwd );
    public int userupdate(User user);
    public User getuserbyid(String userid);
}
