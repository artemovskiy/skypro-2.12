package pro.sky.calculatorsimple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.calculatorsimple.service.CalculatorServiceImpl;


import static pro.sky.calculatorsimple.TestingCalculatorTestConstants.*;

class TestingCalculatorTest {
	private final CalculatorServiceImpl out = new CalculatorServiceImpl();
	int[] twoNumbersActual = new int[]{Integer.parseInt(CORRECT_NUMBER_1), Integer.parseInt(CORRECT_NUMBER_2)};



	@Test
	public void shouldReturnTwoNumbers() {
		int[] twoNumbersExpected = out.checkInt(CORRECT_NUMBER_1, CORRECT_NUMBER_2);
		Assertions.assertArrayEquals(twoNumbersExpected, twoNumbersActual);
	}

	@Test
	public void shouldReturnExceptionIfEmpty() {
		Assertions.assertThrows(NumberFormatException.class,
				() -> out.checkInt(CORRECT_NUMBER_1, EMPTY_CHARACTER));
	}

	@Test
	public void shouldReturnExceptionIfIllegalCharacters() {
		Assertions.assertThrows(NumberFormatException.class,
				() -> out.checkInt(ILLEGAL_CHARACTERS, CORRECT_NUMBER_2));
	}

	@Test
	public void shouldReturnResultOfSum() {
		String sumExpected = out.sum(CORRECT_NUMBER_1, CORRECT_NUMBER_2);
		String sumString = Integer.toString(twoNumbersActual[0] + twoNumbersActual[1]);
		String sumActual = CORRECT_NUMBER_1 + "+" + CORRECT_NUMBER_2 + "=" + sumString;
		Assertions.assertEquals(sumExpected, sumActual);
	}

	@Test
	public void shouldReturnResultOfSubstraction() {
		String subExpected = out.subtraction(CORRECT_NUMBER_1, CORRECT_NUMBER_2);
		String subString = Integer.toString(twoNumbersActual[0] - twoNumbersActual[1]);
		String subActual = CORRECT_NUMBER_1 + "-" + CORRECT_NUMBER_2 + "=" + subString;
		Assertions.assertEquals(subExpected, subActual);
	}

	@Test
	public void shouldReturnResultOfMultiply() {
		String multiExpected = out.multiply(CORRECT_NUMBER_1, CORRECT_NUMBER_2);
		String multiString = Integer.toString(twoNumbersActual[0] * twoNumbersActual[1]);
		String multiActual = CORRECT_NUMBER_1 + "*" + CORRECT_NUMBER_2 + "=" +  multiString;
		Assertions.assertEquals( multiExpected,  multiActual);
	}

	@Test
	public void shouldReturnResultOfDivide() {
		String divideExpected = out.divide(CORRECT_NUMBER_1, CORRECT_NUMBER_2);
		Float temp = (float) twoNumbersActual[0] / twoNumbersActual[1];
		String divideString = Float.toString(temp);
		String divideActual = CORRECT_NUMBER_1 + "/" + CORRECT_NUMBER_2 + "=" +  divideString;
		Assertions.assertEquals( divideExpected,  divideActual);
	}

}
