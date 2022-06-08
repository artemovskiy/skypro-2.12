package pro.sky.calculatorsimple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.calculatorsimple.service.CalculatorServiceImpl;


import static pro.sky.calculatorsimple.TestingCalculatorTestConstants.*;

class TestingCalculatorTest {
    private final CalculatorServiceImpl out = new CalculatorServiceImpl();

    @Test
    public void shouldReturnTwoNumbers() {
        int[] twoNumbersExpected = out.checkInt(CORRECT_NUMBER_1_1, CORRECT_NUMBER_2_1);
        int[] twoNumbersActual = new int[]{Integer.parseInt(CORRECT_NUMBER_1_1), Integer.parseInt(CORRECT_NUMBER_2_1)};
        Assertions.assertArrayEquals(twoNumbersExpected, twoNumbersActual);
    }

    @Test
    public void shouldReturnExceptionIfEmpty() {
        Assertions.assertThrows(NumberFormatException.class,
                () -> out.checkInt(CORRECT_NUMBER_1_1, EMPTY_CHARACTER));
    }

    @Test
    public void shouldReturnExceptionIfIllegalCharacters() {
        Assertions.assertThrows(NumberFormatException.class,
                () -> out.checkInt(ILLEGAL_CHARACTERS_1, CORRECT_NUMBER_2_1));
        // ----- 2-й набор данных --------
        Assertions.assertThrows(NumberFormatException.class,
                () -> out.checkInt(CORRECT_NUMBER_1_2, ILLEGAL_CHARACTERS_2));
    }

    @Test
    public void shouldReturnResultOfSum() {
        String result = out.sum(CORRECT_NUMBER_1_1, CORRECT_NUMBER_2_1);
        Assertions.assertTrue(result.contains(CORRECT_SUM_1));
        Assertions.assertEquals(CORRECT_SUM_1, result);
        // ----- 2-й набор данных --------
        result = out.sum(CORRECT_NUMBER_1_2, CORRECT_NUMBER_2_2);
        Assertions.assertTrue(result.contains(CORRECT_SUM_2));
        Assertions.assertEquals(CORRECT_SUM_2, result);
    }

    @Test
    public void shouldReturnResultOfSubstraction() {
        String result = out.subtraction(CORRECT_NUMBER_1_1, CORRECT_NUMBER_2_1);
        Assertions.assertTrue(result.contains(CORRECT_SUB_1));
        Assertions.assertEquals(CORRECT_SUB_1, result);
        // ----- 2-й набор данных --------
        result = out.subtraction(CORRECT_NUMBER_1_2, CORRECT_NUMBER_2_2);
        Assertions.assertTrue(result.contains(CORRECT_SUB_2));
        Assertions.assertEquals(CORRECT_SUB_2, result);
    }

    @Test
    public void shouldReturnResultOfMultiply() {
        String result = out.multiply(CORRECT_NUMBER_1_1, CORRECT_NUMBER_2_1);
        Assertions.assertTrue(result.contains(CORRECT_MULTI_1));
        Assertions.assertEquals(CORRECT_MULTI_1, result);
        // ----- 2-й набор данных --------
        result = out.multiply(CORRECT_NUMBER_1_2, CORRECT_NUMBER_2_2);
        Assertions.assertTrue(result.contains(CORRECT_MULTI_2));
        Assertions.assertEquals(CORRECT_MULTI_2, result);
    }

    @Test
    public void shouldReturnResultOfDivide() {
        String result = out.divide(CORRECT_NUMBER_1_1, CORRECT_NUMBER_2_1);
        Assertions.assertTrue(result.contains(CORRECT_DIVIDE_1));
        Assertions.assertEquals(CORRECT_DIVIDE_1, result);
        // ----- 2-й набор данных --------
        result = out.divide(CORRECT_NUMBER_1_2, CORRECT_NUMBER_2_2);
        Assertions.assertTrue(result.contains(CORRECT_DIVIDE_2));
        Assertions.assertEquals(CORRECT_DIVIDE_2, result);
    }

    @Test
    public void shouldReturnExceptionIfDividingByZero() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> out.divide(CORRECT_NUMBER_1_1, ZERO_NUMBER));
        // ----- 2-й набор данных --------
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> out.divide(CORRECT_NUMBER_1_2, ZERO_NUMBER));
    }
}
