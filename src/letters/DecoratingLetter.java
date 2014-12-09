package letters;

/**
 * Decorator to add specific features to a letter such as Registered letter and
 * Urgent letter
 * 
 * @author Thomas OSTROWSKI
 * 
 * @param <L>
 *            The type of letter that will be decorated
 */
public abstract class DecoratingLetter<L extends Letter<?>> extends
		Letter<Content> {

	protected Letter<?> letter;

	/**
	 * Constructor of a DecoratingLetter, which initializes the DecoratingLetter
	 * with the letter given in parameters
	 * 
	 * @param l
	 *            The letter that will be decorated
	 */
	public DecoratingLetter(Letter<?> l) {
		super(l.getSender(), l.getReceiver(), l.getContent());
		this.letter = l;
	}

	/**
	 * Returns the cost of the letter
	 */
	public abstract double getCost();

	/**
	 * Do a specific action when the letter is received if needed
	 */
	public abstract void doAction();
}
