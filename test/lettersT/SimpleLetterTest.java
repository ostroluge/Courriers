package lettersT;

import static org.junit.Assert.*;
import letters.Letter;
import letters.SimpleLetter;
import letters.Text;

import org.junit.Test;

import people.Bankaccount;
import people.City;
import people.Inhabitant;

public class SimpleLetterTest {

	City c = new City("Lille");
	Bankaccount bankaccount = new Bankaccount(500.0);
	Inhabitant inh1 = new Inhabitant("Jacky", c, bankaccount);
	Inhabitant inh2 = new Inhabitant("Bernard", c, bankaccount);
	
	@Test
	public void testSimpleLetterInitialization() {
		Text text = new Text("bla bla");
		Letter<Text> l = new SimpleLetter(inh1, inh2, text);
		assertEquals(l.getCost(), 1.0, 0.0);
		assertEquals(l.getContent(), text);
		assertEquals(l.getContent().getDescription(), "text content");
		assertEquals(l.getType(), "simple letter");
		assertEquals(l.getSender(), inh1);
		assertEquals(l.getReceiver(), inh2);
	}
}
