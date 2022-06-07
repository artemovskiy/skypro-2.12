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
    public String sum(@RequestParam(value = "num1", required = false) String n1, @RequestParam (value = "num2", required = false) String n2) {
        return calculatorService.sum(n1,n2);
    }

    @GetMapping(path = "/minus")
    public String subtraction(@RequestParam("num1") String n1, @RequestParam ("num2") String n2) {
        return calculatorService.subtraction(n1,n2);
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam("num1") String n1, @RequestParam ("num2") String n2) {
        return calculatorService.multiply(n1,n2);
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam("num1") String n1, @RequestParam ("num2") String n2) {
        return calculatorService.divide(n1,n2);
    }
}
