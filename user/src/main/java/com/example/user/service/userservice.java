package com.example.user.service;

import com.example.user.pojo.User;

public interface userservice {
    public int userlogin(String userid,String userpwd );
    public int userupdate(User user);
    public User getuserbyid(String userid);
}
