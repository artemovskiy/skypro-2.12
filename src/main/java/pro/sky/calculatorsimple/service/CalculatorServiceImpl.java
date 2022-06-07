package pro.sky.calculatorsimple.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.calculatorsimple.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    private int[] i = new int[2];

    public String welcome() {
        return "<b>Добро пожаловать в калькулятор!</b>";
    }

    // Проверяем на корректность ввода чисел
    public int[] checkInt(String n1, String n2) {
        if (StringUtils.isNotEmpty(n1) && StringUtils.isNotEmpty(n2)
                && StringUtils.isNumeric(n1) && StringUtils.isNumeric(n2)) {
            i[0] = Integer.parseInt(n1.trim());
            i[1] = Integer.parseInt(n2.trim());
        } else throw new NumberFormatException("Введено не число!");
        return i;
    }

    // ------ метод сложения
    public String sum(String n1, String n2) {
        i = checkInt(n1, n2);
        int sum = i[0] + i[1];
        return n1 + "+" + n2 + "=" + sum;
    }

    // ------ метод вычитания
    public String subtraction(String n1, String n2) {
        i = checkInt(n1, n2);
        int sub = i[0] - i[1];
        return n1 + "-" + n2 + "=" + sub;
    }

    // ------ метод умножения
    public String multiply(String n1, String n2) {
        i = checkInt(n1, n2);
        int multi = i[0] * i[1];
        return n1 + "*" + n2 + "=" + multi;
    }

    // ------ метод деления
    public String divide(String n1, String n2) {
        i = checkInt(n1, n2);
        if (i[1] == 0) {
            throw new IllegalArgumentException("Деление на ноль НЕВОЗМОЖНО!");
        }
        float div = (float) i[0] / i[1];
        return n1 + "/" + n2 + "=" + div;
    }
}
