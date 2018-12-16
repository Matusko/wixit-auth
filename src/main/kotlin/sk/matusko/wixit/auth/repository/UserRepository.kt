package sk.matusko.wixit.auth.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository
import sk.matusko.wixit.common.dao.User

interface UserRepository : PagingAndSortingRepository<User, Long> {

    fun findByLastName(lastName: String, pageable: Pageable): Page<User>

    fun findOneByUsername(username: String): User

}