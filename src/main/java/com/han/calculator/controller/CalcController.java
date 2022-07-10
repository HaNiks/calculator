package com.han.calculator.controller;

import com.han.calculator.model.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.DecimalFormat;

@Controller
public class CalcController {

    @PostMapping("/calc")
    public String showResult(Model model, Calculator calculator) {
        double result = getResult(calculator.getFirstNumber(), calculator.getSecondNumber(), calculator.getExpression());
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formatResult = decimalFormat.format(result);
        model.addAttribute("result", "Result: " + formatResult);
        return "calculator";
    }

    @GetMapping
    public ModelAndView showStartPage(Calculator calculator, ModelAndView modelAndView) {
        modelAndView.setViewName("calculator");
        return modelAndView;
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
