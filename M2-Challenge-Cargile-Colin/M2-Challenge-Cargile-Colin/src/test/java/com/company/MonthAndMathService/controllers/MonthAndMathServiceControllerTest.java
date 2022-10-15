package com.company.MonthAndMathService.controllers;

import com.company.MonthAndMathService.Models.Month;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MonthAndMathServiceController.class)
public class MonthAndMathServiceControllerTest {

    @Autowired //dependency-injection
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception{}

    @Test
    public void shouldReturn422StatusCodeIfInputIsOutOfRange() throws Exception {
        mockMvc.perform(get("/month/13"))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturnTheCorrectMonthByMonthNumberAndHaveStatusOK() throws Exception {
        Month outputMonth = new Month(3, 3, "March");
        String outputMonthJson = mapper.writeValueAsString(outputMonth);

        mockMvc.perform(get("/month/{monthNumber}", 3))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputMonthJson));
    }

    @Test
    public void shouldReturnTheRandomMonthAndHaveStatusOk() throws Exception {
        mockMvc.perform(get("/randomMonth"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}