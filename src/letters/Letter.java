package letters;

import people.Inhabitant;

/**
 * Abstract class which defines an unspecific letter
 * 
 * @author Thomas OSTROWSKI
 *
 * @param <C>
 *            Content's type of the letter
 */
public abstract class Letter<C extends Content> {

	protected Inhabitant sender, receiver;
	protected Content c;

	/**
	 * Constructor of a Letter which initializes a letter with a sender, a
	 * receiver and a content
	 * 
	 * @param sender
	 *            Sender of the letter
	 * @param receiver
	 *            Receiver of the letter
	 * @param c
	 *            Content of the letter
	 */
	public Letter(Inhabitant sender, Inhabitant receiver, C c) {
		this.sender = sender;
		this.receiver = receiver;
		this.c = c;
	}

	/**
	 * 
	 * Returns the cost of the letter
	 */
	public abstract double getCost();

	/**
	 * Do a specific action when the letter is received if needed
	 */
	public abstract void doAction();

	public Inhabitant getSender() {
		return this.sender;
	}

	public Inhabitant getReceiver() {
		return this.receiver;
	}

	public Content getContent() {
		return this.c;
	}

	/**
	 * Return the type of the letter
	 * 
	 * @return the type of the letter
	 */
	public abstract String getType();

	/**
	 * String that will be displayed when the letter will be sent
	 */
	public abstract String toString();
}
