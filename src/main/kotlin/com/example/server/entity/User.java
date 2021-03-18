package com.example.server.entity;

import lombok.Data;

@Data
public class User {
    public int user_id;
    public String phoneNumber;
    public String password;
    public String carId;
}
