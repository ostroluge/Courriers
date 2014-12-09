package peopleT;

import static org.junit.Assert.*;

import org.junit.Test;

import people.Bankaccount;

public class BankaccountTest {

	Bankaccount bankaccount = new Bankaccount(5000.0);
	Bankaccount emptyBankaccount = new Bankaccount();
	
	@Test
	public void testBankaccountInitialization() {
		assertEquals(bankaccount.getAmount(), 5000.0, 0.0);
		assertEquals(emptyBankaccount.getAmount(), 0.0, 0.0);
	}

	@Test
	public void testDebitBankaccount() {
		bankaccount.debit(20);
		assertEquals(bankaccount.getAmount(), 4980.0, 0.0);
	}
	
	@Test
	public void testCreditBankaccount() {
		bankaccount.credit(20);
		assertEquals(bankaccount.getAmount(), 5020.0, 0.0);
	}
}
