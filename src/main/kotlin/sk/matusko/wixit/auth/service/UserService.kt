package sk.matusko.wixit.auth.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.validation.annotation.Validated
import sk.matusko.wixit.common.dao.User
import javax.validation.Valid

@Validated
interface UserService {

    fun save(@Valid user: User): User

    fun all(pageable: Pageable): Page<User>

    fun filterByLastName(lastName: String, pageable: Pageable): Page<User>

}