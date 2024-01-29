package com.example.MyJavaWebApp.controller;

import com.example.MyJavaWebApp.services.GreetingService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingService greetingService;

    @Test
    void testGreet() throws Exception {
        // Arrange
        String name = "Prajwal";
        String expectedGreeting = "Hello, " + name + "!";
        Mockito.when(greetingService.generateGreeting(name)).thenReturn(expectedGreeting);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/greet").param("name", name))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("greeting", expectedGreeting));
    }
}
