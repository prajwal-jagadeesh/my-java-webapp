package com.example.MyJavaWebApp.controller;

import com.example.MyJavaWebApp.model.Greeting;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired; // Import the correct annotation
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GreetingController.class)
class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private GreetingController greetingController;

    @Test
    void testGreeting() throws Exception {
        // Arrange
        Greeting mockGreeting = new Greeting(1, "Hello, World!");

        // Modify this line to match the actual method signature in your GreetingController
        when(greetingController.greeting(any(String.class), any(Model.class)))
                .thenReturn("greeting");  // Here, use a String representing the view name

        // Act and Assert
        mockMvc.perform(get("/greeting"))
                .andExpect(status().isOk())
                .andExpect(view().name("greeting"))  // Check if the returned view name matches
                .andExpect(model().attribute("greeting", mockGreeting));  // Check the model attribute
    }
}
