package com.example.wsservermvn

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer
import javax.annotation.PostConstruct

//@Configuration
//@EnableWebSocketMessageBroker
//class WebSocketConfig : WebSocketMessageBrokerConfigurer {
//    private val log = LoggerFactory.getLogger(this.javaClass)
//    @PostConstruct
//    fun init () {
//        log.info("INIT WEBSOCKET config")
//    }
//    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
//        registry.addEndpoint("/ws").setAllowedOrigins("*").withSockJS()
//    }
//
//    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
//        registry.enableSimpleBroker("/topic")
//        registry.setApplicationDestinationPrefixes("/app")
//    }
//
//}