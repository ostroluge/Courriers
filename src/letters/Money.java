package letters;

/**
 * Class which defines the Money that can be added to a PromissaryNote
 * 
 * @author Thomas OSTROWSKI
 */
public class Money implements Content {

	protected double money;

	/**
	 * Constructor of Money that initializes the money to the amount given in
	 * parameters
	 * 
	 * @param m
	 *            The amount of money
	 */
	public Money(double m) {
		this.money = m;
	}

	public String getDescription() {
		return "money content";
	}

	public String toString() {
		String s = "";
		s += this.money;
		return s;
	}
}
