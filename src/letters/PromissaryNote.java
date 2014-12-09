package letters;

import people.Inhabitant;

/**
 * Class which defines a PromissaryNote which is a letter with a money content
 * 
 * @author Thomas OSTROWSKI
 */

public class PromissaryNote extends Letter<Money> {

	protected double basicCost;

	/**
	 * Constructor of a PromissaryNote which initializes it with the sender, the
	 * receiver and the money content given in parameters
	 * 
	 * @param s
	 *            Sender of the PromissaryNote
	 * @param r
	 *            Receiver of the PromissaryNote
	 * @param basicCost
	 *            Amount of money in the PromissaryNote
	 */
	public PromissaryNote(Inhabitant s, Inhabitant r, Money basicCost) {
		super(s, r, basicCost);
	}

	public double getCost() {
		return 1.0 + (1 / 100) * basicCost;
	}

	public void doAction() {
		System.out.println("\t- "
				+ Double.parseDouble(super.c.toString())
				+ " euros are debited from "
				+ super.sender.getName()
				+ " account whose balance is now "
				+ (super.sender.getBankaccount().getAmount() - Double
						.parseDouble(super.c.toString())));
		System.out.println("\t+ "
				+ super.receiver.getName()
				+ " account is credited with "
				+ Double.parseDouble(super.c.toString())
				+ " euros; its balance is now "
				+ (super.receiver.getBankaccount().getAmount() + Double
						.parseDouble(super.c.toString())));

		super.sender.getBankaccount().debit(
				Double.parseDouble(super.c.toString()));
		super.receiver.getBankaccount().credit(
				Double.parseDouble(super.c.toString()));

		Letter<Content> thks = new ThanksLetter(this);

		super.receiver.sendLetter(thks);
	}

	public String getType() {
		return "promissary note";
	}

	public String toString() {
		String s = "";
		s += "-> "
				+ this.getSender().getName()
				+ " mails a promissory note letter whose content is a money content ("
				+ this.getContent().toString() + ") to "
				+ this.getReceiver().getName() + " for a cost of "
				+ this.getCost() + " euro";
		s += "\n\t-" + this.getCost() + " euro is debited from "
				+ this.sender.getName() + " account whose balance is now "
				+ (sender.getBankaccount().getAmount() - this.getCost());
		return s;
	}
}
