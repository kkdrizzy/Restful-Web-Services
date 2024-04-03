package com.example.restfulwebservices.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world-internationalization")
    public String helloWorldInternationalization() {

        String defaultMessage = "";

        Locale locale = LocaleContextHolder.getLocale();
        if (locale.getLanguage().equals("en")) {
            defaultMessage = messageSource.getMessage("good.morning.message", null, "Default Message", locale);

        }
        if (locale.getLanguage().equals("fr")) {
            defaultMessage = messageSource.getMessage("good.morning.message.fr", null, "Default Message", locale);

        }
        return defaultMessage;
    }
    }
