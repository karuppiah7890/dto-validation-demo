package com.example.dtovalidation.controllers;

import com.example.dtovalidation.dtos.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void givenAnInvalidUserDtoShouldThrowError() throws Exception {
        UserDto userDto = new UserDto(null, "something@gmail.com");
        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(userDto)))
                .andExpect(status().isBadRequest());
    }

    private String toJson(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }


}