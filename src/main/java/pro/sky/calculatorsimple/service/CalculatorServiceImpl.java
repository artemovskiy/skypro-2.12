package pro.sky.calculatorsimple.service;

import org.springframework.stereotype.Service;
import pro.sky.calculatorsimple.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    public String welcome() {
        return "<b>Добро пожаловать в калькулятор!</b>";
    }

    // ------ метод сложения
    public int sum(int n1, int n2) {
        return n1 + n2;
    }

    // ------ метод вычитания
    public int subtraction(int n1, int n2) {
        return n1 - n2;
    }

    // ------ метод умножения
    public int multiply(int n1, int n2) {
        return n1 * n2;
    }

    // ------ метод деления
    public float divide(int n1, int n2) {
        if (n2 == 0) {
            throw new IllegalArgumentException("Деление на ноль НЕВОЗМОЖНО!");
        }
        return (float) n1 / n2;
    }
}
