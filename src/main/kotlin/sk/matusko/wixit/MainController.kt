package sk.matusko.wixit

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {

    @RequestMapping(value = ["/"])
    fun home(): String {
        return "Hello Docker World, hot reload test changed"
    }

    @RequestMapping(value = ["/healthcheck"])
    fun healthcheck() {
        return
    }
}
