package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class HelloWorldController {

    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    @ResponseBody
    @GetMapping("/hello-world")
    public Greeting getGreeting(@RequestParam(name = "name", required = false, defaultValue = "User") String name) {
        return new Greeting(counter.incrementAndGet(), name);
    }
}
