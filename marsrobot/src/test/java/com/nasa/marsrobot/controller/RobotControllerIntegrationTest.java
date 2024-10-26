package com.nasa.marsrobot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class RobotControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testMoveRobotEndpoint() throws Exception {
        mockMvc.perform(post("/rest/mars/MMRMMRMM")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.coordinates.x").value(2))
                .andExpect(jsonPath("$.coordinates.y").value(0))
                .andExpect(jsonPath("$.direction").value("SOUTH"));
    }

    @Test
    void testMoveRobotInvalidCommandEndpoint() throws Exception {
        mockMvc.perform(post("/rest/mars/AAA")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testMoveRobotInvalidPositionEndpoint() throws Exception {
        mockMvc.perform(post("/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMMMM")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testMoveRobotMaxPositionNorthEndpoint() throws Exception {
        mockMvc.perform(post("/rest/mars/MMMMM")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.coordinates.x").value(0))
                .andExpect(jsonPath("$.coordinates.y").value(5))
                .andExpect(jsonPath("$.direction").value("NORTH"));
    }
}
