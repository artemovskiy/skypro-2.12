package pro.sky.calculatorsimple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.calculatorsimple.service.CalculatorServiceImpl;

import java.util.stream.Stream;

import static pro.sky.calculatorsimple.TestingCalculatorTestConstants.*;
import static pro.sky.calculatorsimple.TestingCalculatorTestConstants.CORRECT_DIVIDE_2;

public class provideParamsForCalculatorTests {
    private final CalculatorServiceImpl out = new CalculatorServiceImpl();

    public static Stream<Arguments> paramsOfSum() {
        return Stream.of(
                Arguments.of(CORRECT_NUMBER_1_1, CORRECT_NUMBER_2_1, CORRECT_SUM_1),
                Arguments.of(CORRECT_NUMBER_1_2, CORRECT_NUMBER_2_2, CORRECT_SUM_2)
        );
    }

    public static Stream<Arguments> paramsOfSub() {
        return Stream.of(
                Arguments.of(CORRECT_NUMBER_1_1, CORRECT_NUMBER_2_1, CORRECT_SUB_1),
                Arguments.of(CORRECT_NUMBER_1_2, CORRECT_NUMBER_2_2, CORRECT_SUB_2)
        );
    }

    public static Stream<Arguments> paramsOfMultiply() {
        return Stream.of(
                Arguments.of(CORRECT_NUMBER_1_1, CORRECT_NUMBER_2_1, CORRECT_MULTI_1),
                Arguments.of(CORRECT_NUMBER_1_2, CORRECT_NUMBER_2_2, CORRECT_MULTI_2)
        );
    }

    public static Stream<Arguments> paramsOfDivide() {
        return Stream.of(
                Arguments.of(CORRECT_NUMBER_1_1, CORRECT_NUMBER_2_1, CORRECT_DIVIDE_1),
                Arguments.of(CORRECT_NUMBER_1_2, CORRECT_NUMBER_2_2, CORRECT_DIVIDE_2)
        );
    }

    @ParameterizedTest
    @MethodSource("paramsOfSum")
    public void shouldReturnResultOfSum(String num1, String num2, String correct) {
        String result = out.sum(num1, num2);
        Assertions.assertTrue(result.contains(correct));
        Assertions.assertEquals(correct, result);
    }

    @ParameterizedTest
    @MethodSource("paramsOfSub")
    public void shouldReturnResultOfSub(String num1, String num2, String correct) {
        String result = out.subtraction(num1, num2);
        Assertions.assertTrue(result.contains(correct));
        Assertions.assertEquals(correct, result);
    }

    @ParameterizedTest
    @MethodSource("paramsOfMultiply")
    public void shouldReturnResultOfMultiply(String num1, String num2, String correct) {
        String result = out.multiply(num1, num2);
        Assertions.assertTrue(result.contains(correct));
        Assertions.assertEquals(correct, result);
    }

    @ParameterizedTest
    @MethodSource("paramsOfDivide")
    public void shouldReturnResultOfDivide(String num1, String num2, String correct) {
        String result = out.divide(num1, num2);
        Assertions.assertTrue(result.contains(correct));
        Assertions.assertEquals(correct, result);
    }
}
