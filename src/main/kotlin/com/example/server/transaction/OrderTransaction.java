package com.example.server.transaction;

import com.example.server.dao.OrderDao;
import com.example.server.entity.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Service("orderTransaction")
public class OrderTransaction {
    @Autowired
    private OrderDao orderDao;

    @Transactional
    public void closeOrder(int tId) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("tId", tId);
        queryMap.put("closeTime", new Timestamp(System.currentTimeMillis()));
        orderDao.setCloseTime(queryMap);
        queryMap.put("orderState", OrderState.CLOSE);
        orderDao.setOrderState(queryMap);
    }

    @Transactional
    public void finishOrder(int tId) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("tId", tId);
        queryMap.put("closeTime", new Timestamp(System.currentTimeMillis()));
        orderDao.setCloseTime(queryMap);
        queryMap.put("orderState", OrderState.FINISHED);
        orderDao.setOrderState(queryMap);
    }

}
