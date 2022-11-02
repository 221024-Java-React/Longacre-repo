package Lab8;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Lab8Test {

	@Test
	public void posTestOne() {
		assertEquals(new Lab8().reverse("Absolutely"), "yletulosbA");
	}
	
	@Test
	public void posTestTwo() {
		assertEquals(new Lab8().reverse("Dont cha know"), "wonk ahc tnoD");
	}
	
	@Test
	public void negTestOne() {
		assertEquals(new Lab8().reverse("Absolutely"), "Absolutely");
	}
	
	@Test
	public void negTestTwo() {
		assertEquals(new Lab8().reverse("Dont cha know"), "Dont cha know");
	}
	
}
