package people;

import java.util.ArrayList;
import java.util.List;

import letters.Letter;

/**
 * Class which defines a City, with a list of inhabitants, a name and a postBox
 * 
 * @author Thomas OSTROWSKI
 *
 */
public class City {

	protected List<Inhabitant> inhabitants;
	protected String name;
	protected List<Letter<?>> postBox;

	/**
	 * Constructor of a City that initializes the City with the name given in
	 * parameters
	 * 
	 * @param name
	 *            Name of the city
	 */
	public City(String name) {
		this.inhabitants = new ArrayList<Inhabitant>();
		this.name = name;
		this.postBox = new ArrayList<Letter<?>>();
	}

	public List<Inhabitant> getInhabitants() {
		return inhabitants;
	}

	public String getName() {
		return name;
	}

	public List<Letter<?>> getPostBox() {
		return postBox;
	}

	/**
	 * Adds the letter given in parameters to the postBox of the city
	 * 
	 * @param l
	 *            The letter that will be added to the postBox
	 */
	public void sendLetter(Letter<?> l) {
		postBox.add(l);
	}

	/**
	 * It distributes the letters that are in the postBox of the city
	 */
	public void distributeLetters() {
		List<Letter<?>> postalBag = new ArrayList<Letter<?>>(postBox);
		for (Letter<?> letter : postalBag) {
			letter.getReceiver().receiveLetter(letter);
			postBox.remove(letter);
		}
	}
}
