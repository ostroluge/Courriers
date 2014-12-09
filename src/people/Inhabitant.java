package people;

import letters.Content;
import letters.Letter;

/**
 * Class which defines an Inhabitant with a name, a city and a bankaccount
 * 
 * @author Thomas OSTROWSKI
 */
public class Inhabitant {

	protected String name;
	protected City city;
	protected Bankaccount bankaccount;

	public Inhabitant() {
	};

	/**
	 * Constructor of an Inhabitant which initializes his name, his city and his
	 * bankaccount with the values given in parameters
	 * 
	 * @param n
	 *            Inhabitant's name
	 * @param c
	 *            Inhabitant's city
	 * @param ba
	 *            Inhabitant's bankaccount
	 */
	public Inhabitant(String n, City c, Bankaccount ba) {
		this.name = n;
		this.city = c;
		this.bankaccount = ba;
	}

	/**
	 * Shows that an inhabitant has received a letter
	 * 
	 * @param letter
	 *            The letter that has been received
	 */
	public void receiveLetter(Letter<?> letter) {
		Content content = letter.getContent();

		if (letter.getType() == "thanks letter"
				|| letter.getType() == "acknowledgment letter") {
			System.out.println("<- " + letter.getSender().getName()
					+ " receives a " + letter.getType()
					+ " whose content is a " + content.getDescription() + "("
					+ content.toString() + ") from "
					+ letter.getReceiver().getName());
			letter.doAction();
		} else {
			System.out.println("<- " + letter.getReceiver().getName()
					+ " receives a " + letter.getType()
					+ " whose content is a " + content.getDescription() + "("
					+ content.toString() + ") from "
					+ letter.getSender().getName());
			letter.doAction();
		}
	}

	/**
	 * Sends the letter by adding it to the postBox of the City
	 * 
	 * @param l
	 *            Letter that will be added to the postBox of the City
	 */
	public void sendLetter(Letter<?> l) {

		System.out.println(l.toString());

		l.getSender().getBankaccount().debit(l.getCost());

		this.city.sendLetter(l);
	}

	public String getName() {
		return this.name;
	}

	public Bankaccount getBankaccount() {
		return this.bankaccount;
	}

	public City getCity() {
		return this.city;
	}
}
