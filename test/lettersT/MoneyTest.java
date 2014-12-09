package lettersT;

import static org.junit.Assert.*;
import letters.Money;

import org.junit.Test;

public class MoneyTest {

	@Test
	public void testMoneyInitialization() {
		Money money = new Money(25.0);
		assertEquals(money.getDescription(), "money content");
		assertEquals(money.toString(), "25.0");
	}
}
