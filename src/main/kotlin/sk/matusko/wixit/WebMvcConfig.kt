package sk.matusko.wixit

import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import sk.matusko.wixit.logging.LogInterceptor


@Configuration
class WebMvcConfig : WebMvcConfigurer {

    @Autowired
    private val logInterceptor: LogInterceptor? = null

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(logInterceptor!!)
                .addPathPatterns("/**")
    }
}