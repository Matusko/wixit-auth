package sk.matusko.wixit.async

import org.slf4j.MDC
import org.slf4j.MDC.setContextMap
import org.slf4j.MDC.getCopyOfContextMap
import org.springframework.core.task.TaskDecorator


class MDCTaskDecorator : TaskDecorator {

    override fun decorate(runnable: Runnable): Runnable {
        val contextMap = MDC.getCopyOfContextMap()
        return Runnable {
            try {
                MDC.setContextMap(contextMap)
                runnable.run()
            } finally {
                MDC.clear()
            }
        }
    }
}