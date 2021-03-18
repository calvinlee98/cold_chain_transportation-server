package com.example.server.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class Order {
    //订单号 作为主键
    public int t_id;
    //运输者 reference key参考User Id
    public int uId;
    //来源地
    public String origin;
    //目的地
    public String destination;
    //订单开始时间
    public Timestamp openTime;
    //订单结束时间
    public Timestamp closeTime;
    //核酸检测情况
    public boolean passCovidTest;
    //核酸监测海关
    public String covidTestCustom;
    //核酸检测 delay的天数
    public int covidTestDuration;
    //当前订单状态
    public OrderState orderState;
}
