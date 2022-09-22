package uz.devcraft.wsbackdemo

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import uz.devops.annotation.WsRpcMethod
import uz.devops.annotation.WsRpcParam
import uz.devops.annotation.WsRpcService

@Service
@WsRpcService("customRpcService")
class CustomRpcService(
) {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @WsRpcMethod("sum")
    fun sum(@WsRpcParam("a")a: Int, @WsRpcParam("b") b: Int): Int {
        log.debug("Request to sum a: $a and b: $b")
        return a + b
    }
}