package pro.sky.calculatorsimple.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculatorsimple.CalculatorService;

@RestController
@RequestMapping(path = "/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }


    @GetMapping
    public String welcome() {
        return calculatorService.welcome();
    }

    @GetMapping(path = "/plus")
    public int sum(@RequestParam("num1") int n1, @RequestParam ("num2") int n2) {
        return calculatorService.sum(n1,n2);
        // n1 + "+" + n2 + "=" +
    }

    @GetMapping(path = "/minus")
    public int subtraction(@RequestParam("num1") int n1, @RequestParam ("num2") int n2) {
        return calculatorService.subtraction(n1,n2);
    }

    @GetMapping(path = "/multiply")
    public int multiply(@RequestParam("num1") int n1, @RequestParam ("num2") int n2) {
        return calculatorService.multiply(n1,n2);
    }

    @GetMapping(path = "/divide")
    public float divide(@RequestParam("num1") int n1, @RequestParam ("num2") int n2) {
        return calculatorService.divide(n1,n2);
    }
}
