package com.example.server.controller

import com.example.server.dao.TransportDao
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest
import com.example.server.entity.TransportData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpMethod
import org.springframework.web.bind.annotation.RequestMethod
import java.sql.Timestamp

@RestController
@RequestMapping(value = ["/transport"])
class TransportController {
    @Autowired
    lateinit var transportDao: TransportDao

    @RequestMapping(value = ["/log"], method = [RequestMethod.GET])
    fun logTransportData(request: HttpServletRequest): Int {
        val tId = request.getParameter("tId").toInt()
        val timestamp = Timestamp(System.currentTimeMillis())
        val temperature = request.getParameter("temperature").toInt()
        val curPlace = request.getParameter("curPlace")
        val transportData = TransportData()
        transportData.apply {
            this.tId = tId
            this.curTime = timestamp
            this.temperature = temperature
            this.curPlace = curPlace
        }
        return transportDao.log(transportData)
    }

    @RequestMapping(value = ["/get"], method = [RequestMethod.GET])
    fun getLogs(request: HttpServletRequest): List<TransportData> {
        val tId = request.getParameter("tId").toInt()
        return transportDao.getLogs(tId)
    }
}