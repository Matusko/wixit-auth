package sk.matusko.wixit

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import sk.matusko.wixit.exceptions.InvalidState

import javax.validation.ConstraintViolationException

@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {


    @ExceptionHandler(ConstraintViolationException::class)
    fun handleAccessDeniedException(ex: ConstraintViolationException, request: WebRequest): ResponseEntity<InvalidState> {

        val invalidState = InvalidState()

        return ResponseEntity(invalidState, HttpHeaders(), HttpStatus.BAD_REQUEST)
    }

}