package letters;

/**
 * Class which defines a ThanksLetter which is sent when an inhabitant receives
 * a PromissaryNote
 * 
 * @author Thomas OSTROWSKI
 *
 */
public class ThanksLetter extends Letter<Content> {

	/**
	 * Constructor of the ThanksLetter which is initialized with the
	 * PromissaryNote given in parameters
	 * 
	 * @param promissaryNote
	 *            PromissaryNote that will trigger the sending of the
	 *            ThanksLetter
	 */
	public ThanksLetter(PromissaryNote promissaryNote) {
		super(promissaryNote.getSender(), promissaryNote.getReceiver(),
				promissaryNote.getContent());
	}

	public double getCost() {
		return 1;
	}

	public void doAction() {
	};

	public String getType() {
		return "thanks letter";
	}

	public String toString() {
		String s = "";
		Text thksText = new Text(
				"thanks for a promissary note letter whose content is a money content("
						+ super.c.toString() + ")");
		super.c = thksText;

		s += "-> " + this.receiver.getName() + " mails a " + this.getType()
				+ " which is a simple letter whose content is a text content ("
				+ thksText + ") to " + this.sender.getName()
				+ " for a cost of " + this.getCost() + " euro";
		s += "\n\t-" + this.getCost() + " euro is debited from "
				+ this.receiver.getName() + " account whose balance is now "
				+ (receiver.getBankaccount().getAmount() - this.getCost());
		return s;
	}
}
