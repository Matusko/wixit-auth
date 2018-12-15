package sk.matusko.wixit.auth.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import sk.matusko.wixit.auth.repository.UserRepository
import sk.matusko.wixit.common.dao.User

@Service
class UserServiceImpl @Autowired
constructor(private val repository: UserRepository) : UserService {

    override fun save(user: User): User {
        return this.repository.save(user)
    }

    override fun all(pageable: Pageable): Page<User> {
        return this.repository.findAll(pageable)
    }

    override fun filterByLastName(lastName: String, pageable: Pageable): Page<User> {
        return this.repository.findByLastName(lastName, pageable)
    }

}