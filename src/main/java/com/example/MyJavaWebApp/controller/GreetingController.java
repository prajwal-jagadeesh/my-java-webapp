package com.example.MyJavaWebApp.controller;

import com.example.MyJavaWebApp.model.Greeting;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name, Model model) {
        Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
        model.addAttribute("greeting", greeting);
        return "greeting";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
