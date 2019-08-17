package sk.matusko.wixit

import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sk.matusko.wixit.auth.service.AsyncService
import java.util.concurrent.CompletableFuture


private val logger = KotlinLogging.logger {}
@RestController
class MainController
@Autowired constructor(private val asyncService: AsyncService){

    @RequestMapping(value = ["/"])
    fun home(): String {
        return "Hello Docker World, test CI with CFN changed"
    }

    @RequestMapping(value = ["/async-test"])
    fun asyncTest(): String {
        val list1 = asyncService.getList1()
        val list2 = asyncService.getList2()

        CompletableFuture.allOf(list1, list2).join();

        logger.info("list1--> " + list1.get());
        logger.info("list2--> " + list2.get());

        return  list1.get() + " = " + list2.get()
    }

    @RequestMapping(value = ["/healthcheck"])
    fun healthcheck() {
        return
    }
}
