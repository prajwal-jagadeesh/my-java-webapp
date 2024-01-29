// GreetingService.java
package com.example.MyJavaWebApp.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String generateGreeting(String name) {
        return "Hello, " + name + "!";
    }
}
