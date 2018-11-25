package sk.matusko.wixit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping(value = "/")
    public String home() {
        return "Hello Docker World, hot reload test changed";
    }

    @RequestMapping(value = "/healthcheck")
    public void healthcheck() {
        return;
    }
}
