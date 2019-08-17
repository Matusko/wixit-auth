package sk.matusko.wixit

import org.junit.Assert.assertEquals

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = arrayOf(Application::class))
@DirtiesContext
class MainControllerIT {

    @LocalServerPort
    private val port: Int = 0

    @Autowired
    private val restTemplate: TestRestTemplate? = null

    @Test
    @Throws(Exception::class)
    fun testGreeting() {
        val entity = restTemplate!!
                .getForEntity("http://localhost:" + this.port + "/", String::class.java)
        assertEquals(HttpStatus.OK, entity.statusCode)
    }

}
