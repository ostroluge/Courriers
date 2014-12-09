package lettersT;

import static org.junit.Assert.*;
import letters.Letter;
import letters.Money;
import letters.PromissaryNote;
import letters.RegisteredLetter;

import org.junit.Test;

import people.Bankaccount;
import people.City;
import people.Inhabitant;

public class RegisteredLetterTest {

	City c = new City("Lille");
	Bankaccount bankaccount = new Bankaccount(500.0);
	Inhabitant inh1 = new Inhabitant("Jacky", c, bankaccount);
	Inhabitant inh2 = new Inhabitant("Bernard", c, bankaccount);
	Money money = new Money(25.0);
	Letter<Money> promissary = new PromissaryNote(inh1, inh2, money);
	
	@Test
	public void testRegisteredLetterInitialization() {
		RegisteredLetter<Letter<Money>> rl = new RegisteredLetter<Letter<Money>>(promissary);
		assertEquals(rl.getCost(), 16.0, 0.0);
		assertEquals(rl.getType(), "registered letter");
		assertEquals(rl.getSender(), inh1);
		assertEquals(rl.getReceiver(), inh2);
		assertEquals(rl.getContent(), money);
		assertEquals(rl.getContent().getDescription(), "money content");
		c.sendLetter(promissary);
		c.distributeLetters();
		assertEquals(inh1.getBankaccount().getAmount(), 484.0, 0.0);
	}
}
