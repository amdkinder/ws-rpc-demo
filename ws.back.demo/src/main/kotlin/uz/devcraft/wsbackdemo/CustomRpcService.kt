package uz.devcraft.wsbackdemo

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import uz.devops.annotation.WsRpcMethod
import uz.devops.annotation.WsRpcParam
import uz.devops.annotation.WsRpcService
import uz.devops.model.JsonRpcRequest
import uz.devops.model.WsData
import uz.devops.service.ArtemisClient

@Service
@WsRpcService("customRpcService")
class CustomRpcService(
    private val artemisClient: ArtemisClient
) {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @WsRpcMethod("sum")
    fun sum(@WsRpcParam("a") a: Int, @WsRpcParam("b") b: Int): Int {
        log.debug("Request to sum a: $a and b: $b")
        return a + b
    }

//    @WsRpcMethod("getProducts")
//    fun sum(@WsRpcParam("pageable") pageAble: PageRequestDTO): String? {
//        log.debug("Request to getProducts: $pageAble")
//        var data = WsData(
//            true,
//            "productms",
//            "unknown",
//            "username",
//            JsonRpcRequest(System.currentTimeMillis().toString(),
//                "2.0", "getAllProducts", mapOf("pageable" to pageAble))
//        )
//        var response = artemisClient.sendAndReceive("productms", data)
//        return response.getBody(String::class.java);
//    }
}


data class PageRequestDTO(
    var size: Int? = 20,
    var page: Int? = 0
)
