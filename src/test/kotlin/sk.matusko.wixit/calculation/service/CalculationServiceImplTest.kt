package sk.matusko.wixit.calculation.service

import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import java.math.BigDecimal
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
@SpringBootTest
class CalculationServiceImplTest {

    @InjectMocks
    lateinit var calculationService: CalculationServiceImpl

    @Test
    fun calculate_return1191_inputIs51dot344() {
        val result = this.calculationService.calculate(BigDecimal("18"))
        assertEquals(BigDecimal("51.344"), result)
    }

}