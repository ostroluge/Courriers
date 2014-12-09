package peopleT;

import static org.junit.Assert.*;

import org.junit.Test;

import people.Bankaccount;
import people.City;
import people.Inhabitant;

public class InhabitantTest {

	City c = new City("Lille");
	Bankaccount bankaccount = new Bankaccount(500.0);
	Inhabitant inh1; 
	Inhabitant inh2 = new Inhabitant("Bernard", c, bankaccount);
	
	@Test
	public void testInhabitantInitialization() {
		inh1 = new Inhabitant("Jacky", c, bankaccount);
		assertEquals(inh1.getName(), "Jacky");
		assertEquals(inh1.getBankaccount(), bankaccount);
		assertEquals(inh1.getCity(), c);
	}
}
