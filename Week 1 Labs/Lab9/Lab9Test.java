package Lab9;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class Lab9Test {

	char[] charOne = {'A', 'B', 'C', 'D'};
	char[] charTwo = {'A', 'A', 'C', 'F'};
	int[] bonusOne = {5000, 2500, 1000, 500};
	int[] bonusTwo = {5000, 5000, 1000, 0};
		
	@Test
	public void posTestOne() {
		assertArrayEquals(new Lab9().calculateBonuses(charOne), bonusOne);
	}
	
	@Test
	public void posTestTwo() {
		assertArrayEquals(new Lab9().calculateBonuses(charTwo), bonusTwo);
	}
	
	@Test 
	public void negTestOne() {
		assertArrayEquals(new Lab9().calculateBonuses(charOne), bonusTwo);
	}
	
	@Test
	public void negTestTwo() {
		assertArrayEquals(new Lab9().calculateBonuses(charTwo), bonusOne);
	}
		
}
