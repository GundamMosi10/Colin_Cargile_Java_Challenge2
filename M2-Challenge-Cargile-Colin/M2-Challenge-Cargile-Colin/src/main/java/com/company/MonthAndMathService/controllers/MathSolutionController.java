package com.company.MonthAndMathService.controllers;


import com.company.MonthAndMathService.Models.MathSolution;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class MathSolutionController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution sumOfTwoNums(@RequestBody @Valid MathSolution mathSolution) {
        if(mathSolution.getOperand1() == null || mathSolution.getOperand2() == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "You must have a valid inputs.");
        }
        mathSolution.setAnswer(mathSolution.getOperand1() + mathSolution.getOperand2());
        mathSolution.setOperation("add");
        return mathSolution;
    }

    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution differenceOfTwoNums(@RequestBody @Valid MathSolution mathSolution) {
        if(mathSolution.getOperand1() == null || mathSolution.getOperand2() == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "You must have a valid inputs.");
        }
        mathSolution.setAnswer(mathSolution.getOperand1() - mathSolution.getOperand2());
        mathSolution.setOperation("subtract");
        return mathSolution;
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution productOfTwoNums(@RequestBody @Valid MathSolution mathSolution) {
        if(mathSolution.getOperand1() == null || mathSolution.getOperand2() == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "You must have a valid inputs.");
        }
        mathSolution.setAnswer(mathSolution.getOperand1() * mathSolution.getOperand2());
        mathSolution.setOperation("multiply");
        return mathSolution;
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution quotientOfTwoNums(@RequestBody @Valid MathSolution mathSolution) {
        if(mathSolution.getOperand1() == null || mathSolution.getOperand2() == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "You must have a valid inputs.");
        }
        mathSolution.setAnswer(mathSolution.getOperand1() / mathSolution.getOperand2());
        mathSolution.setOperation("divide");
        return mathSolution;
    }
}
