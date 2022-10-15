package com.company.MonthAndMathService.controllers;

import com.company.MonthAndMathService.Models.MathSolution;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(MathSolutionController.class)
public class MathSolutionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    //Addition Tests
    @Test
    public void shouldReturnTheSumOfTwoNums() throws Exception {
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand1(20);
        mathSolution.setOperand2(10);

        String mathSolutionJson = mapper.writeValueAsString(mathSolution);

        MathSolution outputMathSolution = new MathSolution(20,10, "add", 30);
        String outputMathSolutionJson = mapper.writeValueAsString(outputMathSolution);

        mockMvc.perform(post("/add")
                .content(mathSolutionJson)
                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputMathSolutionJson));
    }

    @Test
    public void shouldReturnError422IfOneOperandIsMissing() throws Exception {
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand2(10);

        String mathSolutionJson = mapper.writeValueAsString(mathSolution);

        mockMvc.perform(post("/add")
                .content(mathSolutionJson)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturnError422IfTheOtherOperandIsMissing() throws Exception {
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand1(20);

        String mathSolutionJson = mapper.writeValueAsString(mathSolution);

        mockMvc.perform(post("/add")
                        .content(mathSolutionJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                        .andDo(print())
                        .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturnError422IfBothOperandsAreMissing() throws Exception {
        MathSolution mathSolution = new MathSolution();
        String mathSolutionJson = mapper.writeValueAsString(mathSolution);

        mockMvc.perform(post("/add")
                        .content(mathSolutionJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                        .andDo(print())
                        .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturnError422IfTheInputIsNotAnInteger() throws Exception {
        Map<String, String> mathSolution = new HashMap<>();
        mathSolution.put("operand1", "DarthVader");
        mathSolution.put("operand2", "DeathStar");

        String mathSolutionJson = mapper.writeValueAsString(mathSolution);

        mockMvc.perform(post("/add")
                        .content(mathSolutionJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                        .andDo(print())
                        .andExpect(status().isUnprocessableEntity());
    }

    //Subtraction Tests
    @Test
    public void shouldReturnTheDifferenceOfTwoNums() throws Exception {
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand1(20);
        mathSolution.setOperand2(10);

        String mathSolutionJson = mapper.writeValueAsString(mathSolution);

        MathSolution outputMathSolution = new MathSolution(20,10, "subtract", 10);
        String outputMathSolutionJson = mapper.writeValueAsString(outputMathSolution);

        mockMvc.perform(post("/subtract")
                        .content(mathSolutionJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                        .andDo(print())
                        .andExpect(status().isCreated())
                        .andExpect(content().json(outputMathSolutionJson));
    }

    @Test
    public void shouldReturnError422IfOneOperandIsMissingForSubtraction() throws Exception {
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand2(10);

        String mathSolutionJson = mapper.writeValueAsString(mathSolution);

        mockMvc.perform(post("/subtract")
                        .content(mathSolutionJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                        .andDo(print())
                        .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturnError422IfTheOtherOperandIsMissingForSubtraction() throws Exception {
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand1(20);

        String mathSolutionJson = mapper.writeValueAsString(mathSolution);

        mockMvc.perform(post("/subtract")
                        .content(mathSolutionJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                        .andDo(print())
                        .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturnError422IfBothOperandsAreMissingForSubtraction() throws Exception {
        MathSolution mathSolution = new MathSolution();
        String mathSolutionJson = mapper.writeValueAsString(mathSolution);

        mockMvc.perform(post("/subtract")
                        .content(mathSolutionJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                        .andDo(print())
                        .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturnError422IfTheInputIsNotAnIntegerForSubtraction() throws Exception {
        Map<String, String> mathSolution = new HashMap<>();
        mathSolution.put("operand1", "SpikeSpiegel");
        mathSolution.put("operand2", "FayeValentine");

        String mathSolutionJson = mapper.writeValueAsString(mathSolution);

        mockMvc.perform(post("/subtract")
                        .content(mathSolutionJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                        .andDo(print())
                        .andExpect(status().isUnprocessableEntity());
    }

    //Multiplication Tests
    @Test
    public void shouldReturnTheProductOfTwoNums() throws Exception {
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand1(20);
        mathSolution.setOperand2(10);

        String mathSolutionJson = mapper.writeValueAsString(mathSolution);

        MathSolution outputMathSolution = new MathSolution(20,10, "multiply", 200);
        String outputMathSolutionJson = mapper.writeValueAsString(outputMathSolution);

        mockMvc.perform(post("/multiply")
                        .content(mathSolutionJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                        .andDo(print())
                        .andExpect(status().isCreated())
                        .andExpect(content().json(outputMathSolutionJson));
    }

    @Test
    public void shouldReturnError422IfOneOperandIsMissingForMultiplication() throws Exception {
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand2(10);

        String mathSolutionJson = mapper.writeValueAsString(mathSolution);

        mockMvc.perform(post("/multiply")
                        .content(mathSolutionJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                        .andDo(print())
                        .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturnError422IfTheOtherOperandIsMissingForMultiplication() throws Exception {
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand1(20);

        String mathSolutionJson = mapper.writeValueAsString(mathSolution);

        mockMvc.perform(post("/multiply")
                        .content(mathSolutionJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                        .andDo(print())
                        .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturnError422IfBothOperandsAreMissingForMultiplication() throws Exception {
        MathSolution mathSolution = new MathSolution();
        String mathSolutionJson = mapper.writeValueAsString(mathSolution);

        mockMvc.perform(post("/multiply")
                        .content(mathSolutionJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                        .andDo(print())
                        .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturnError422IfTheInputIsNotAnIntegerForMultiplication() throws Exception {
        Map<String, String> mathSolution = new HashMap<>();
        mathSolution.put("operand1", "CharAznable");
        mathSolution.put("operand2", "AmuroRay");

        String mathSolutionJson = mapper.writeValueAsString(mathSolution);

        mockMvc.perform(post("/multiply")
                        .content(mathSolutionJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                        .andDo(print())
                        .andExpect(status().isUnprocessableEntity());
    }

    //Division Tests
    @Test
    public void shouldReturnTheQuotientOfTwoNums() throws Exception {
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand1(20);
        mathSolution.setOperand2(10);

        String mathSolutionJson = mapper.writeValueAsString(mathSolution);

        MathSolution outputMathSolution = new MathSolution(20,10, "divide", 2);
        String outputMathSolutionJson = mapper.writeValueAsString(outputMathSolution);

        mockMvc.perform(post("/divide")
                        .content(mathSolutionJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                        .andDo(print())
                        .andExpect(status().isCreated())
                        .andExpect(content().json(outputMathSolutionJson));
    }

    //Division when 0 is the numerator
    @Test
    public void shouldReturnZeroWhenNumeratorIsZero() throws Exception {
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand1(0);
        mathSolution.setOperand2(100);

        String mathSolutionJson = mapper.writeValueAsString(mathSolution);

        MathSolution outputMathSolution = new MathSolution(0,100, "divide", 0);
        String outputMathSolutionJson = mapper.writeValueAsString(outputMathSolution);

        mockMvc.perform(post("/divide")
                        .content(mathSolutionJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                        .andDo(print())
                        .andExpect(status().isCreated())
                        .andExpect(content().json(outputMathSolutionJson));
    }

    //Division when 0 is the denominator
    @Test
    public void shouldReturnError422WhenDenominatorIsZero() throws Exception {
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand1(100);
        mathSolution.setOperand2(0);

        String mathSolutionJson = mapper.writeValueAsString(mathSolution);

        mockMvc.perform(post("/divide")
                        .content(mathSolutionJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                        .andDo(print())
                        .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturnError422IfOneOperandIsMissingForDivision() throws Exception {
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand2(10);

        String mathSolutionJson = mapper.writeValueAsString(mathSolution);

        mockMvc.perform(post("/divide")
                        .content(mathSolutionJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                        .andDo(print())
                        .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturnError422IfTheOtherOperandIsMissingForDivision() throws Exception {
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand1(20);

        String mathSolutionJson = mapper.writeValueAsString(mathSolution);

        mockMvc.perform(post("/divide")
                        .content(mathSolutionJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                        .andDo(print())
                        .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturnError422IfBothOperandsAreMissingForDivision() throws Exception {
        MathSolution mathSolution = new MathSolution();
        String mathSolutionJson = mapper.writeValueAsString(mathSolution);

        mockMvc.perform(post("/divide")
                        .content(mathSolutionJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                        .andDo(print())
                        .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturnError422IfTheInputIsNotAnIntegerForDivision() throws Exception {
        Map<String, String> mathSolution = new HashMap<>();
        mathSolution.put("operand1", "VashTheStampede");
        mathSolution.put("operand2", "MerylStryfe");

        String mathSolutionJson = mapper.writeValueAsString(mathSolution);

        mockMvc.perform(post("/divide")
                        .content(mathSolutionJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                        .andDo(print())
                        .andExpect(status().isUnprocessableEntity());
    }
}