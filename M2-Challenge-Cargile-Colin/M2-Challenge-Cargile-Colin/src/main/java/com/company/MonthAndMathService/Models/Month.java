package com.company.MonthAndMathService.Models;

import java.util.Objects;

public class Month {
    private int id;
    private int number;
    private String name;

    public Month() {
    }

    public Month(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public Month(int id, int number, String name) {
        this.id = id;
        this.number = number;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month = (Month) o;
        return id == month.id && number == month.number && Objects.equals(name, month.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, name);
    }

    @Override
    public String toString() {
        return "Month{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}




