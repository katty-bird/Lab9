package calc;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalcTest {
    private CalcEngine calcDec;
    private CalcEngineHex calcHex;

	@BeforeEach
	void setUp() throws Exception {
		calcDec = new CalcEngine();	
		calcHex = new CalcEngineHex();
	}

	@Test
	void testPlusDec() {
		calcDec.numberPressed(8);
		calcDec.plus();
		calcDec.numberPressed(2);
		calcDec.equals();
		Assert.assertEquals(10, calcDec.getDisplayValue());
	}
	
	@Test
	void testMinusDec() {
		calcDec.numberPressed(20);
		calcDec.minus();
		calcDec.numberPressed(5);
		calcDec.equals();
		Assert.assertEquals(15, calcDec.getDisplayValue());
	}
	
	@Test
	void testMultiplyDec() {
		calcDec.numberPressed(10);
		calcDec.multiply();
		calcDec.numberPressed(10);
		calcDec.equals();
		Assert.assertEquals(100, calcDec.getDisplayValue());
	}
	
	@Test
	void testDivisionDec() {
		calcDec.numberPressed(1000);
		calcDec.division();
		calcDec.numberPressed(2);
		calcDec.equals();
		Assert.assertEquals(500, calcDec.getDisplayValue());
	}
	
	@Test
	void testPlusHex() {
		calcHex.numberPressed(Integer.parseInt("A", 16));
		calcHex.plus();
		calcHex.numberPressed(2);
		calcHex.equals();
		Assert.assertEquals("C", Integer.toHexString(calcHex.getDisplayValue()).toUpperCase());
	}
	
	@Test
	void testMinusHex() {
		calcHex.numberPressed(Integer.parseInt("D", 16));
		calcHex.minus();
		calcHex.numberPressed(Integer.parseInt("A", 16));
		calcHex.equals();
		Assert.assertEquals("3", Integer.toHexString(calcHex.getDisplayValue()).toUpperCase());
	}
}
