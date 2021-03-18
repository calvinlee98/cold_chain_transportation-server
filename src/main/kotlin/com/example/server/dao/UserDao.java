package com.example.server.dao;

import com.example.server.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserDao {
    int createNewUser(User user);
    String getUserPassword(String phoneNumber);
}
