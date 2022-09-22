package com.example.wsservermvn

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Controller
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import uz.devops.model.WsData
import uz.devops.service.WsArtemisRpcService
import javax.annotation.PostConstruct

@Controller
@EnableWebSocketMessageBroker
class WebSocketResource(
    private val wsRpcService: WsArtemisRpcService,
    private val objectMapper: ObjectMapper
) {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @PostConstruct
    fun init() {
        log.info("INIT WEBSOCKET config")
    }

    @MessageMapping("/app/greet")
    fun greetMessage(@Payload message: String) {
        log.info("REQUEST TO GREAT FROM WS CLIENT: $message")
        val data = objectMapper.readValue(message, WsData::class.java)
        data.username = "username"
        data.destination = "/topic/greet"
        log.info("REQUEST TO GREAT FROM WS CLIENT: $data")
        wsRpcService.send(data.service, data)
    }

    @MessageMapping("/greet")
    fun greetMessage2(@Payload message: String) {
        log.debug("greetMessage2")
        return greetMessage(message)
    }
}