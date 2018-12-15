package sk.matusko.wixit.exceptions

import java.math.BigInteger
import java.time.LocalDateTime

class InvalidState {

    var time = LocalDateTime.now()
    var message: String? = null
    var uid: String? = null
    var code: BigInteger? = null

}
