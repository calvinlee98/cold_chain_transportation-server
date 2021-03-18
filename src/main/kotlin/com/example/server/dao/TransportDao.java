package com.example.server.dao;

import com.example.server.entity.TransportData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TransportDao {
    int log(TransportData data);

    List<TransportData> getLogs(int tId);
}
