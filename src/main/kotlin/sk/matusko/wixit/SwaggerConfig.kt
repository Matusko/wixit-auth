package sk.matusko.wixit

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger.web.SecurityConfiguration
import springfox.documentation.swagger2.annotations.EnableSwagger2
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.swagger.web.ApiKeyVehicle
import org.springframework.web.bind.annotation.RequestMethod
import springfox.documentation.schema.ModelRef
import springfox.documentation.builders.ResponseMessageBuilder
import springfox.documentation.service.AuthorizationScope
import springfox.documentation.service.GrantType
import springfox.documentation.service.OAuth
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant
import springfox.documentation.service.ResponseMessage
import springfox.documentation.service.SecurityReference
import java.util.Collections


@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Value("\${custom.swagger.oauthPath}")
    private val contextPath: String? = null

    @Bean
    fun api(): Docket {

        val list = java.util.ArrayList<ResponseMessage>()
        list.add(ResponseMessageBuilder().code(500).message("500 message")
                .responseModel(ModelRef("Result")).build())
        list.add(ResponseMessageBuilder().code(401).message("Unauthorized")
                .responseModel(ModelRef("Result")).build())
        list.add(ResponseMessageBuilder().code(406).message("Not Acceptable")
                .responseModel(ModelRef("Result")).build())

        return Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build().securitySchemes(Collections.singletonList(securitySchema()))
                .securityContexts(Collections.singletonList(securityContext())).pathMapping("/")
                .useDefaultResponseMessages(false).globalResponseMessage(RequestMethod.GET, list)
                .globalResponseMessage(RequestMethod.POST, list)


    }

    private fun securitySchema(): OAuth {

        val authorizationScopeList = ArrayList<AuthorizationScope>()
        authorizationScopeList.add(AuthorizationScope("read", "read all"))
        authorizationScopeList.add(AuthorizationScope("trust", "trust all"))
        authorizationScopeList.add(AuthorizationScope("write", "access all"))

        val grantTypes = ArrayList<GrantType>()
        val creGrant = ResourceOwnerPasswordCredentialsGrant(this.contextPath + "/oauth/token")

        grantTypes.add(creGrant)

        return OAuth("oauth2schema", authorizationScopeList, grantTypes)

    }

    private fun securityContext(): SecurityContext {
        return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.ant("/"))
                .build()
    }

    private fun defaultAuth(): List<SecurityReference> {

        val authorizationScopes = arrayOfNulls<AuthorizationScope>(3)
        authorizationScopes[0] = AuthorizationScope("read", "read all")
        authorizationScopes[1] = AuthorizationScope("trust", "trust all")
        authorizationScopes[2] = AuthorizationScope("write", "write all")

        return Collections.singletonList(SecurityReference("oauth2schema", authorizationScopes))
    }

    @Bean
    fun securityInfo(): SecurityConfiguration {
        return SecurityConfiguration("gigy", "secret", "", "", "", ApiKeyVehicle.HEADER, "", " ")
    }

}