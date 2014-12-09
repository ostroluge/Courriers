package letters;

/**
 * Class with defines a RegisteredLetter which once it's received trigger the
 * sending of a receipt of acknowledgment
 * 
 * @author Thomas OSTROWSKI
 *
 * @param <C>
 *            The content's type of the registered letter
 */
public class RegisteredLetter<C extends Letter<?>> extends DecoratingLetter<C> {

	/**
	 * Constructor of the RegisteredLetter which make the letter given in
	 * parameters registered
	 * 
	 * @param l
	 *            The letter that will be registered
	 */
	public RegisteredLetter(Letter<?> l) {
		super(l);
	}

	public double getCost() {
		return super.letter.getCost() + 15.0;
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

		Letter<Content> acknowledgment = new ReceiptAcknowledgmentLetter(this);

		super.receiver.sendLetter(acknowledgment);
	}

	public String getType() {
		return "registered letter";
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
