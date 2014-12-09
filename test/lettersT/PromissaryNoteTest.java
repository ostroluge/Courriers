package lettersT;

import static org.junit.Assert.*;
import letters.Letter;
import letters.Money;
import letters.PromissaryNote;

import org.junit.Test;

import people.Bankaccount;
import people.City;
import people.Inhabitant;

public class PromissaryNoteTest {

	City c = new City("Lille");
	Bankaccount bankaccount = new Bankaccount(500.0);
	Inhabitant inh1 = new Inhabitant("Jacky", c, bankaccount);
	Inhabitant inh2 = new Inhabitant("Bernard", c, bankaccount);
	Money money = new Money(25.0);
	Letter<Money> promissary = new PromissaryNote(inh1, inh2, money);
	
	@Test
	public void testPromissaryNoteInitialization() {
		assertEquals(promissary.getCost(), 1.0, 0.0);
		assertEquals(promissary.getType(), "promissary note");
		assertEquals(promissary.getSender(), inh1);
		assertEquals(promissary.getReceiver(), inh2);
		assertEquals(promissary.getContent(), money);
		assertEquals(promissary.getContent().getDescription(), "money content");
	}

	@Test
	public void testSendingPromissaryNote() {
		c.sendLetter(promissary);
		c.distributeLetters();
		assertEquals(inh1.getBankaccount().getAmount(), 499.0, 0.0);
		assertEquals(inh2.getBankaccount().getAmount(), 499.0, 0.0);
	}
	
}
