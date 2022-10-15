package com.company.MonthAndMathService.controllers;

import com.company.MonthAndMathService.Models.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class MonthAndMathServiceController {

    private Random rng;
    private List<Month> monthList;

    public MonthAndMathServiceController() {
        rng = new Random();

        int monthNumber = 1;
        monthList = new ArrayList<>(Arrays.asList(
                new Month(monthNumber++, 1, "January"),
                new Month(monthNumber++, 2, "February"),
                new Month(monthNumber++, 3, "March"),
                new Month(monthNumber++, 4, "April"),
                new Month(monthNumber++, 5, "May"),
                new Month(monthNumber++, 6, "June"),
                new Month(monthNumber++, 7, "July"),
                new Month(monthNumber++, 8, "August"),
                new Month(monthNumber++, 9, "September"),
                new Month(monthNumber++, 10, "October"),
                new Month(monthNumber++, 11, "November"),
                new Month(monthNumber++, 12, "December")

        ));
    }

    @RequestMapping(value = "/month/{monthNumber}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Month getMonthByMonthNumber(@PathVariable int monthNumber) {
        Month foundMonth = null;

        for(Month month : monthList) {
            if(month.getId() == monthNumber) {
                foundMonth = month;
                break;
            }
        }

        if (foundMonth == null) {
            throw new NotFoundException("Month not found in the collection");
        }

        return foundMonth;
    }



    @GetMapping(value = "/randomMonth")
    @ResponseStatus(value = HttpStatus.OK)
    public Month getRandomMonth() {
        return monthList.get(rng.nextInt(monthList.size()));
    }
}
