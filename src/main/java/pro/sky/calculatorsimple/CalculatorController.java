package pro.sky.calculatorsimple;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }


    @GetMapping
    public String welcome() {
        return CalculatorService.welcome();
    }

    @GetMapping(path = "/plus")
    public String sum(@RequestParam("num1") String n1, @RequestParam ("num2") String n2) {
        return CalculatorService.sum(n1,n2);
    }

    @GetMapping(path = "/minus")
    public String subtraction(@RequestParam("num1") String n1, @RequestParam ("num2") String n2) {
        return CalculatorService.subtraction(n1,n2);
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam("num1") String n1, @RequestParam ("num2") String n2) {
        return CalculatorService.multiply(n1,n2);
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam("num1") String n1, @RequestParam ("num2") String n2) {
        return CalculatorService.divide(n1,n2);
    }
}
