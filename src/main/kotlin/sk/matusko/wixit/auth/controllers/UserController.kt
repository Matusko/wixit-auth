package sk.matusko.wixit.auth.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.querydsl.QPageRequest
import org.springframework.web.bind.annotation.*
import sk.matusko.wixit.auth.service.UserService
import sk.matusko.wixit.common.dao.User

@RestController
@RequestMapping(value = ["/users"])
class UserController
@Autowired constructor(private val userService: UserService) {

    @PostMapping()
    fun createUser(@RequestBody user: User): User {
        userService.save(user)
        return user
    }

    @GetMapping()
    fun users(): Page<User> {
        val pageable = QPageRequest(0, 10)

        return userService.all(pageable)
    }
}
