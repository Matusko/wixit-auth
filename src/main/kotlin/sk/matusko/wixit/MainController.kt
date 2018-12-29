package sk.matusko.wixit

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {

    @RequestMapping(value = ["/"])
    fun home(): String {
        return "Hello Docker World, docker test with redis"
    }

    @RequestMapping(value = ["/healthcheck"])
    fun healthcheck() {
        return
    }
}
