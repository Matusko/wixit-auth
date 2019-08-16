package sk.matusko.wixit.auth.service

import org.springframework.validation.annotation.Validated
import java.util.concurrent.CompletableFuture

@Validated
interface AsyncService {

    fun getList1(): CompletableFuture<String>

    fun getList2(): CompletableFuture<String>

}