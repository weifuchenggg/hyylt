package com.example.user.serviceimpl;

import com.example.user.mapper.UserMapper;
import com.example.user.pojo.User;
import com.example.user.pojo.UserExample;
import com.example.user.service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userservice")
public class userserviceimpl implements userservice {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int userlogin(String userid, String userpwd) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        criteria.andUserpasswordEqualTo(userpwd);
        return this.userMapper.countByExample(userExample);
    }

    @Override
    public int userupdate(User user) {
        return this.userMapper.updateByPrimaryKey(user);
    }

    @Override
    public User getuserbyid(String userid) {

        return this.userMapper.selectByPrimaryKey(userid);

    }
}
