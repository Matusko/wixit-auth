package sk.matusko.wixit.calculation.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import sk.matusko.wixit.auth.repository.UserRepository
import sk.matusko.wixit.common.dao.User
import java.math.BigDecimal
import java.math.RoundingMode

@Service
class CalculationServiceImpl : CalculationService {
    override fun calculate(num: BigDecimal): BigDecimal {
        val b1 = BigDecimal("54.2")
        val b2 = BigDecimal("14.20")

        val b3 = b1.multiply(b2)
        return b3.divide(BigDecimal("14.99"), RoundingMode.HALF_UP)
    }

}