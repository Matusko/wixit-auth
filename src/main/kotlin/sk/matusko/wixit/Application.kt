package sk.matusko.wixit

import org.springframework.boot.SpringApplication
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootConfiguration
@SpringBootApplication
class Application {
    fun main(args: Array<String>) {
        SpringApplication.run(Application::class.java, *args)
    }
}

