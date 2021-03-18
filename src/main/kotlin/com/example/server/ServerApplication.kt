package com.example.server

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.transaction.annotation.EnableTransactionManagement

@EnableTransactionManagement
@SpringBootApplication()
@EnableAutoConfiguration(exclude = [DruidDataSourceAutoConfigure::class])
class ServerApplication

fun main(args: Array<String>) {
    runApplication<ServerApplication>(*args)
}
