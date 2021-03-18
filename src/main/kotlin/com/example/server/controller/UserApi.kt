package com.example.server.controller

import com.example.server.dao.UserDao
import com.example.server.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping(value = ["/user"])
class UserApiController {
    @Autowired
    lateinit var userDao: UserDao

    @RequestMapping(value = ["/register"], method = [RequestMethod.GET])
    fun register(request: HttpServletRequest): Int {
        val phoneNumber = request.getParameter("phoneNumber")
        val password = request.getParameter("password")
        val carId = request.getParameter("carId")
        val newUser = User()
        newUser.phoneNumber = phoneNumber
        newUser.password = password
        newUser.carId = carId
        userDao.createNewUser(newUser)
        return newUser.user_id
    }

    @RequestMapping(value = ["/login"],method = [RequestMethod.GET])
    fun login(request: HttpServletRequest):Boolean{
        val reqPhoneNumber = request.getParameter("phoneNumber")
        val reqPassword = request.getParameter("password")
        return reqPassword == userDao.getUserPassword(reqPhoneNumber)
    }

}