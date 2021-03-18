package com.example.server.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class TransportData {
    public int tId;
    public String curPlace;
    public int temperature;
    public Timestamp curTime;
}
