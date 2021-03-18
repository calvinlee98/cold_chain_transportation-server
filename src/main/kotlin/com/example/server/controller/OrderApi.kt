package com.example.server.controller

import com.example.server.dao.OrderDao
import com.example.server.entity.Order
import com.example.server.entity.OrderState
import com.example.server.transaction.OrderTransaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.sql.Timestamp
import java.util.*
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping(value = ["/order"])
class OrderApiController {
    @Autowired
    lateinit var orderDao: OrderDao

    @Autowired
    lateinit var orderTransaction: OrderTransaction

    @RequestMapping(value = ["/create"], method = [RequestMethod.GET])
    fun create(request: HttpServletRequest): Int {
        val order = Order()
        order.uId = request.getParameter("uId").toInt()
        order.origin = request.getParameter("origin")
        order.destination = request.getParameter("destination")
        order.openTime = Timestamp(System.currentTimeMillis())
        order.passCovidTest = request.getParameter("passCovidTest").toBoolean()
        order.covidTestCustom = request.getParameter("covidTestCustom")
        order.covidTestDuration = request.getParameter("covidTestDuration").toInt()
        order.orderState = OrderState.ON
        return orderDao.createNewOrder(order)

    }

    @RequestMapping(value = ["/get"], method = [RequestMethod.GET])
    fun getOrder(request: HttpServletRequest): Order {
        return orderDao.getOrder(request.getParameter("tId").toInt())

    }

    @RequestMapping(value = ["/close"], method = [RequestMethod.GET])
    fun closeOrder(request: HttpServletRequest): Boolean {
        orderTransaction.closeOrder(request.getParameter("tId").toInt())
        return true;
    }

    @RequestMapping(value = ["/finish"], method = [RequestMethod.GET])
    fun finishOrder(request: HttpServletRequest): Boolean {
        orderTransaction.finishOrder(request.getParameter("tId").toInt());
        return true;
    }


}