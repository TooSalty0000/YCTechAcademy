package com.example.sns.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PostControllerTest {

    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    final String TITLE = "Title Test";
    final String CONTENT = "Content Test";

    @Test
    public void getPostTest() throws Exception {
        this.mockMvc.perform(
                get("/post/{postId}", "1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("data")))
                .andExpect(jsonPath("$.data").exists())
                .andDo(print());

    }
}
