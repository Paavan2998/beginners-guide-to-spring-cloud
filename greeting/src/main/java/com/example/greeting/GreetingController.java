package com.example.greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class GreetingController {
    private static final Logger LOG = Logger.getLogger(GreetingController.class.getName());

    private GreetingProperties greetingProperties;

    public GreetingController(GreetingProperties greetingProperties){
        this.greetingProperties = greetingProperties;
    }
    @GetMapping("/{languageCode}")
    public String getGreeting(@PathVariable String languageCode){
        LOG.info("Language Code: " + languageCode);
        LOG.info("Greeting: " + greetingProperties.getGreetings().get(languageCode.toUpperCase()));
        return greetingProperties.getGreetings().getOrDefault(languageCode.toUpperCase(), greetingProperties.getGreeting());
    }
    @GetMapping("/")
    public String getGreeting(){
        LOG.info("Greeting: " + greetingProperties);
        return greetingProperties.getGreeting();
    }
}
