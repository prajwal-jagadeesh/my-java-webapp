// GreetingController.java
package com.example.MyJavaWebApp.controller;

import com.example.MyJavaWebApp.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greet")
    public String greet(@RequestParam(name = "name", defaultValue = "Guest") String name, Model model) {
        String greeting = greetingService.generateGreeting(name);
        model.addAttribute("greeting", greeting);
        return "greeting";
    }

    @GetMapping("/")
    public String greetingPage() {
        return "greeting";
    }
}
