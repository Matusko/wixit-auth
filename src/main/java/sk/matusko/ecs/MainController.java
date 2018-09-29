package sk.matusko.ecs;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping(value = "/")
    public String home() {
        return "Hello Docker World, i changed have added webhooks in seprate repo with logger another test";
    }

    @RequestMapping(value = "/healthcheck")
    public void healthcheck() {
        return;
    }
}
