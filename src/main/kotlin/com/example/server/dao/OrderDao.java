package com.example.server.dao;

import com.example.server.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.Map;

@Mapper
public interface OrderDao {
    int createNewOrder(Order order);

    Order getOrder(int tId);

    int setCloseTime(Map<String, Object> map);

    int setOrderState(Map<String, Object> map);
}
