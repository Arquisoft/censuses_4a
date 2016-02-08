package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import main.Calculator;

public class CalculatorTest {

@Test
public void evalAdd() {
		Calculator calc = new Calculator();
		Integer expected = 5;
		assertEquals(calc.add(3, 2), expected);
}


}
