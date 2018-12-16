package sk.matusko.wixit

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore
import sk.matusko.wixit.auth.service.UserService

@Configuration
@EnableAuthorizationServer
class OAuth2Config : AuthorizationServerConfigurerAdapter() {

    @Autowired
    @Qualifier("userService")
    private val userService: UserService? = null

    @Autowired
    private val authenticationManager: AuthenticationManager? = null

    @Autowired
    private val tokenStore: TokenStore? = null

    @Value("\${gigy.oauth.tokenTimeout:3600}")
    private val expiration: Int = 0

    // password encryptor
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun tokenStore(redisConnectionFactory: RedisConnectionFactory): TokenStore {
        return RedisTokenStore(redisConnectionFactory)
    }

    /*@Bean
    public PasswordEncoder oauthClientPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

    @Throws(Exception::class)
    override fun configure(configurer: AuthorizationServerEndpointsConfigurer?) {
        configurer!!.authenticationManager(authenticationManager)
        configurer.userDetailsService(userService)
        configurer.tokenStore(this.tokenStore)
    }

    @Throws(Exception::class)
    override fun configure(clients: ClientDetailsServiceConfigurer?) {
        clients!!.inMemory()
                .withClient("gigy")
                .secret(passwordEncoder().encode("secret"))
                .accessTokenValiditySeconds(expiration)
                .scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token")
    }

}
