package letters;

import people.Inhabitant;

/**
 * Class which defines a SimpleLetter which is a letter with a text content
 * 
 * @author Thomas OSTROWSKI
 *
 */
public class SimpleLetter extends Letter<Text> {

	static final protected double COST = 1;

	/**
	 * Constructor of the SimpleLetter which initializes with the sender, the
	 * receiver and the text content given in parameters
	 * 
	 * @param s
	 *            The sender of the SimpleLetter
	 * @param r
	 *            The receiver of the SimpleLetter
	 * @param t
	 *            The text content of the SimpleLetter
	 */
	public SimpleLetter(Inhabitant s, Inhabitant r, Text t) {
		super(s, r, t);
	}

	@SuppressWarnings("static-access")
	public double getCost() {
		return this.COST;
	}

	public void doAction() {
	};

	public String getType() {
		return "simple letter";
	}

	public String toString() {
		String s = "";
		s += "-> " + this.getSender().getName() + " mails a " + this.getType()
				+ " whose content is a " + this.getContent().getDescription()
				+ "(" + (this.getContent().toString()) + ") to "
				+ this.getReceiver().getName() + " for a cost of "
				+ this.getCost();
		s += "\n\t- " + this.getCost() + " euro is debited from "
				+ sender.getName() + " account whose balance is now "
				+ (sender.getBankaccount().getAmount() - this.getCost());
		return s;
	}

}
