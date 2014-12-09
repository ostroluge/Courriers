package peopleT;

import static org.junit.Assert.*;
import letters.Money;
import letters.PromissaryNote;
import letters.SimpleLetter;
import letters.Text;

import org.junit.Test;

import people.Bankaccount;
import people.City;
import people.Inhabitant;

public class CityTest {

	City c = new City("Lille");
	Bankaccount bankaccount = new Bankaccount(500.0);
	Inhabitant inh1 = new Inhabitant("Jacky", c, bankaccount);
	Inhabitant inh2 = new Inhabitant("Bernard", c, bankaccount);

	@Test
	public void testCityInitilization() {
		assertEquals("Lille", c.getName());
		assertTrue(c.getInhabitants().isEmpty());
		assertTrue(c.getPostBox().isEmpty());
	}

	@Test
	public void testAddingPeopleToTheCity() {
		assertTrue(c.getInhabitants().isEmpty());
		c.getInhabitants().add(inh1);
		assertEquals(c.getInhabitants().size(), 1);
		c.getInhabitants().add(inh2);
		assertEquals(c.getInhabitants().size(), 2);
	}

	@Test
	public void testAddingLetterToThePostBox() {
		Text text = new Text("bla bla");
		SimpleLetter letter = new SimpleLetter(inh1, inh2, text);
		assertTrue(c.getPostBox().isEmpty());
		c.sendLetter(letter);
		assertEquals(c.getPostBox().size(), 1);
	}

	@Test
	public void testDistributingLetter() {
		Text text = new Text("bla bla");
		Money money = new Money(23.0);
		SimpleLetter letter = new SimpleLetter(inh1, inh2, text);
		PromissaryNote promissary = new PromissaryNote(inh2, inh1, money);
		assertTrue(c.getPostBox().isEmpty());
		c.sendLetter(letter);
		assertEquals(c.getPostBox().size(), 1);
		c.sendLetter(promissary);
		assertEquals(c.getPostBox().size(), 2);
		c.distributeLetters();
		assertEquals(c.getPostBox().size(), 1); /*
												 * is equals to one because the
												 * receiver of the promissary
												 * note has sent a thanks letter
												 */
	}
}
