package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by e052988 on 1/30/18.
 */
@RestController
public class WelcomeController {

    String welcomeMessage;

    public WelcomeController(@Value("${WELCOME_MESSAGE}") String message) {
        this.welcomeMessage=message;
    }

    @GetMapping("/")
    public String sayHello() {
        return welcomeMessage;
    }
}
