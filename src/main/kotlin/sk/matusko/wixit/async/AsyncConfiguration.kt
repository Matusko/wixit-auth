package sk.matusko.wixit.async

import java.util.concurrent.Executor

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor

@Configuration
@EnableAsync
class AsyncConfiguration {
    @Bean(name = ["asyncExecutor"])
    fun asyncExecutor(): Executor {
        val executor = ThreadPoolTaskExecutor()
        executor.corePoolSize = 50
        executor.maxPoolSize = 50
        executor.setQueueCapacity(100)
        executor.threadNamePrefix = "AsyncThread-"
        executor.initialize()
        executor.setTaskDecorator(MDCTaskDecorator())
        return executor
    }

}