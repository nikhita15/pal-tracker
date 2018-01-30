package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by e052988 on 1/30/18.
 */
@RestController
public class WelcomeController {

    @GetMapping("/")
    public String sayHello() {
        return "hello";
    }
}
