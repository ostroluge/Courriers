package letters;

/**
 * Class which define a ReceiptAcknoledgmentLetter which is sent when someone
 * receives a registered letter
 * 
 * @author Thomas OSTROWSKI
 */
public class ReceiptAcknowledgmentLetter extends Letter<Content> {

	/**
	 * Constructor of a ReceiptAcknowledgmentLetter which initializes it with
	 * the registered letter given in parameters
	 * 
	 * @param regLetter
	 *            Registered Letter that will trigger the sending of the receipt
	 *            of acknowledgment
	 */
	public ReceiptAcknowledgmentLetter(RegisteredLetter<?> regLetter) {
		super(regLetter.getSender(), regLetter.getReceiver(), regLetter
				.getContent());
	}

	public double getCost() {
		return 1.0;
	}

	public void doAction() {
	};

	public String getType() {
		return "acknowledgment receipt";
	}

	public String toString() {
		String s = "";
		Text acknowledgment = new Text(
				"acknowledgment of receipt for a registred letter whose content is a "
						+ super.c.getDescription() + "(" + super.c.toString()
						+ ")");
		super.c = acknowledgment;

		s += "-> " + this.receiver.getName() + " mails a " + this.getType()
				+ " which is a simple letter whose content is a text content ("
				+ acknowledgment + ") to " + this.sender.getName()
				+ " for a cost of " + this.getCost() + " euro";
		s += "\n\t- "
				+ this.getCost()
				+ " euro is debited from "
				+ this.sender.getName()
				+ " account whose balance is now "
				+ (this.getReceiver().getBankaccount().getAmount() - this
						.getCost());
		return s;
	}
}
