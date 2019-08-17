package sk.matusko.wixit.auth.service

import mu.KotlinLogging
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

private val logger = KotlinLogging.logger {}

@Service
class AsyncServiceImpl : AsyncService {

    @Async("asyncExecutor")
    override fun getList1(): CompletableFuture<String> {
        logger.info { "getList1" }
        return CompletableFuture.completedFuture("one one one")
    }

    @Async("asyncExecutor")
    override fun getList2(): CompletableFuture<String> {
        logger.info { "getList1" }
        return CompletableFuture.completedFuture("to twwo two")
    }


}