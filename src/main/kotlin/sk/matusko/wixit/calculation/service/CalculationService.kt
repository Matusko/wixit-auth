package sk.matusko.wixit.calculation.service

import java.math.BigDecimal

interface CalculationService {

    fun calculate(num: BigDecimal): BigDecimal

}