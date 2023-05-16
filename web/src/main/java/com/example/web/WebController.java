package com.example.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.util.logging.Logger;

/**
 * Created by Paavan Shah on 16-05-2023.
 */
@RestController
public class WebController {
    private static final Logger LOG = Logger.getLogger(WebController.class.getName());

    private NameService nameService;
    private GreetingService greetingService;

    public WebController(NameService nameService, GreetingService greetingService) {
        this.nameService = nameService;
        this.greetingService = greetingService;
    }

    @RequestMapping("/g")
    public String index(HttpServletRequest request){
        String locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request).toLanguageTag();
        String greeting = new StringBuilder().append(greetingService.getGreeting(locale))
                .append(" ").append(nameService.getName()).toString();
        LOG.info("Greeting: " + greeting);
        LOG.info("Locale: " + locale);
        return greeting;
    }
}
