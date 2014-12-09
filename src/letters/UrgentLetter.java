package letters;

/**
 * Class which define an UrgentLetter that cost twice as much as the letter sent
 * 
 * @author Thomas OSTROWSKI
 *
 * @param <C>
 *            The content's type of the UrgentLetter
 */
public class UrgentLetter<C extends Letter<?>> extends DecoratingLetter<C> {

	/**
	 * Constructor of the UrgentLetter which initializes the letter given in
	 * parameters as urgent
	 * 
	 * @param l
	 *            Letter that will be considered urgent
	 */
	public UrgentLetter(Letter<?> l) {
		super(l);
	}

	public double getCost() {
		return super.letter.getCost() * 2;
	}

	public void doAction() {
		if (super.c.getDescription() == "money content") {
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
		}
		if (super.letter.getType() == "registered letter") {
			String s = "";
			Text acknowledgment = new Text(
					"acknowledgment of receipt for a registred letter whose content is a "
							+ super.c.getDescription() + "("
							+ super.c.toString() + ")");
			super.c = acknowledgment;

			s += "-> "
					+ this.receiver.getName()
					+ " mails a acknowledgment of receipt which is a simple letter whose content is a text content ("
					+ acknowledgment + ") to " + this.sender.getName()
					+ " for a cost of " + this.getCost() + " euro";
			s += "\n\t- " + 1.0 + " euro is debited from "
					+ this.receiver.getName()
					+ " account whose balance is now "
					+ (this.getReceiver().getBankaccount().getAmount() - 1.0);
			System.out.println(s);
		}
	}

	public String getType() {
		return "urgent letter";
	}

	public String toString() {
		String s = "";
		s += "-> " + this.getSender().getName() + " mails a " + this.getType()
				+ " whose content is a " + this.getContent().getDescription()
				+ "(" + (this.getContent().toString()) + ") to "
				+ this.getReceiver().getName() + " for a cost of "
				+ this.getCost();
		s += "\n\t- " + this.getCost() + " euros are debited from "
				+ sender.getName() + " account whose balance is now "
				+ (sender.getBankaccount().getAmount() - this.getCost());
		return s;
	}
}
