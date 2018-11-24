package sk.matusko.ecs;

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController() {

    @GetMapping("/kotlin")
    fun helloKotlin(): String {
        return "hello kotlin something change"
    }
}