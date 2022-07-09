package com.han.calculator.controller;

import com.han.calculator.model.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalcController {

    @PostMapping("/calc")
    public String showResult(Model model, Calculator calculator) {
        double result = getResult(calculator.getFirstNumber(), calculator.getSecondNumber(), calculator.getExpression());
        model.addAttribute("result", result);
        return "calculator";
    }

    @GetMapping()
    public String showStartPage() {
        return "greeting";
    }

    private double getResult(double a, double b, String expression) {
        double res = 0;
        switch (expression) {
            case "sum" -> res = a + b;
            case "sub" -> res = a - b;
            case "div" -> res = a / b;
            case "mul" -> res = a * b;
        }
        return res;
    }
}
