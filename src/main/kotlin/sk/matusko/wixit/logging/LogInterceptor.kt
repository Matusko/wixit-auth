package sk.matusko.wixit.logging

import mu.KotlinLogging
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletResponse
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import org.slf4j.MDC;
import java.text.MessageFormat
import java.util.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler


private val logger = KotlinLogging.logger {}

@Component
class LogInterceptor : HandlerInterceptor {
    @Throws(Exception::class)
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        MDC.put("request_id", UUID.randomUUID().toString());

        var service = MessageFormat.format("{0}=>{1}", request.method, request.requestURI)
        var controllerMethod = "None"

        if (handler is HandlerMethod) {
            val method = handler as HandlerMethod

            val requestMapping = method.getMethodAnnotation(RequestMapping::class.java)
            val getMapping = method.getMethodAnnotation(GetMapping::class.java)
            val postMapping = method.getMethodAnnotation(PostMapping::class.java)
            val patchMapping = method.getMethodAnnotation(PatchMapping::class.java)
            val putMapping = method.getMethodAnnotation(PutMapping::class.java)
            val deleteMapping = method.getMethodAnnotation(DeleteMapping::class.java)

            var uri = ""

            if (requestMapping != null) {
                uri =  Arrays.toString(requestMapping.value)
            }
            if (getMapping != null) {
                uri =  Arrays.toString(getMapping.value)
            }
            if (postMapping != null) {
                uri =  Arrays.toString(postMapping.value)
            }
            if (patchMapping != null) {
                uri =  Arrays.toString(patchMapping.value)
            }
            if (putMapping != null) {
                uri =  Arrays.toString(putMapping.value)
            }
            if (deleteMapping != null) {
                uri =  Arrays.toString(deleteMapping.value)
            }
            service = MessageFormat.format("{0}=>{1}", request.method, uri)
            controllerMethod = MessageFormat.format("{0}.{1}", method.beanType.simpleName, method.method.name )
        }


        MDC.put("service", service)
        MDC.put("controller_method", controllerMethod)

        return true
    }

    @Throws(Exception::class)
    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any, modelAndView: ModelAndView?) {
    }

    @Throws(Exception::class)
    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any, exception: Exception?) {
        MDC.clear()
    }

    private fun getFullURL(request: HttpServletRequest): String {
        val requestURL = StringBuilder(request.requestURL.toString())
        val queryString = request.queryString

        return if (queryString == null) {
            requestURL.toString()
        } else {
            requestURL.append('?').append(queryString).toString()
        }
    }
}