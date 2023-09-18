package pro.sky.calculatorsimple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
class CalculatorServiceTest {

	private final CalculatorService service = new CalculatorService();

	public static Stream<Arguments> testSumParams() {
		return Stream.of(
				Arguments.of(2, 3, 5),
				Arguments.of(3, 2, 5),
				Arguments.of(0, 2, 2)
		);
	}

	@ParameterizedTest
	@MethodSource("testSumParams")
	void testSum(int a, int b, int expected) {
		int actual = service.sum(a, b);
		Assertions.assertEquals(expected, actual);
	}

	public static Stream<Arguments> testDivParams() {
		return Stream.of(
				Arguments.of(10, 2, 5f),
				Arguments.of(10, 5, 2f),
				Arguments.of(5, 2, 2.5f)
		);
	}

	@ParameterizedTest
	@MethodSource("testDivParams")
	void testDiv(int a, int b, float expected) {
		float actual = service.divide(a, b);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void testDivByZeroThrows() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.divide(5, 0));
	}

}
