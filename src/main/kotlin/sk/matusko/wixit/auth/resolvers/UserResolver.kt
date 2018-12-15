package sk.matusko.wixit.auth.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import sk.matusko.wixit.common.dao.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import sk.matusko.wixit.auth.service.UserService
import org.springframework.data.querydsl.QPageRequest


@Component
class UserResolver @Autowired
constructor(private val userService: UserService) : GraphQLMutationResolver, GraphQLQueryResolver {

    fun createUser(user: User): User {
        userService.save(user)
        return user
    }

    fun users(): Page<User> {
        val pageable = QPageRequest(0, 10)

        return userService.all(pageable)
    }
}