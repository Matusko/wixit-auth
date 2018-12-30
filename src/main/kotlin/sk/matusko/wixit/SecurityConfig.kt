package sk.matusko.wixit

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig : ResourceServerConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
                .authorizeRequests()
                .antMatchers("/healthcheck").permitAll()
                .antMatchers("/oauth/**").permitAll()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/users").permitAll()
                .anyRequest().authenticated()
    }
}