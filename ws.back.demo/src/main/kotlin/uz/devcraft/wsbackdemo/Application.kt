package uz.devcraft.wsbackdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import uz.devops.config.JWsRpcProperties

@SpringBootApplication(scanBasePackages = ["uz.devops", "uz.devcraft"])
@EnableConfigurationProperties(
    value = [
        JWsRpcProperties::class
    ]
)
@EnableScheduling
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
