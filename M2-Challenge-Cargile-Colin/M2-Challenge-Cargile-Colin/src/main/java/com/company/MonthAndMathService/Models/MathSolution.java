package com.company.MonthAndMathService.Models;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class MathSolution {

    private int id;
    @NotNull(message = "input number cannot be null")
    private Integer operand1;
    @NotNull(message = "input number cannot be null")
    private Integer operand2;
    private String operation;
    private int answer;

    public MathSolution() {
    }

    public MathSolution(Integer operand1, Integer operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public MathSolution(Integer operand1, Integer operand2, String operation, int answer) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
        this.answer = answer;

    }

    public MathSolution(int id, Integer operand1, Integer operand2, String operation, int answer) {
        this.id = id;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
        this.answer = answer;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getOperand1() {
        return operand1;
    }

    public void setOperand1(Integer operand1) {
        this.operand1 = operand1;
    }

    public Integer getOperand2() {
        return operand2;
    }

    public void setOperand2(Integer operand2) {
        this.operand2 = operand2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int add(Integer operand1, Integer operand2) {
        return operand1 + operand2;
    }

    public int subtract(Integer operand1, Integer operand2) {
        return operand1 - operand2;
    }

    public int multiply(Integer operand1, Integer operand2) {
        return operand1 * operand2;
    }

    public int divide(Integer operand1, Integer operand2) {
        return operand1 / operand2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathSolution that = (MathSolution) o;
        return id == that.id && answer == that.answer && Objects.equals(operand1, that.operand1) && Objects.equals(operand2, that.operand2) && Objects.equals(operation, that.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, operand1, operand2, operation, answer);
    }

    @Override
    public String toString() {
        return "MathSolution{" +
                "id=" + id +
                ", operand1=" + operand1 +
                ", operand2=" + operand2 +
                ", operation='" + operation + '\'' +
                ", answer=" + answer +
                '}';
    }
}
