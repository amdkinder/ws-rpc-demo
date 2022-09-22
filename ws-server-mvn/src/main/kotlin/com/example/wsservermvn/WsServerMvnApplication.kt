package com.example.wsservermvn

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import uz.devops.config.JWsRpcProperties

@SpringBootApplication(scanBasePackages = ["uz.devops", "com.example"])
@EnableConfigurationProperties(
    value = [
        JWsRpcProperties::class
    ]
)
class WsServerMvnApplication

fun main(args: Array<String>) {
    runApplication<WsServerMvnApplication>(*args)
}
