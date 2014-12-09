package people;

/**
 * Class which defines a Bankaccount for an inhabitant
 * 
 * @author Thomas OSTROWSKI
 *
 */
public class Bankaccount {

	protected double amount;

	/**
	 * Constructor of a Bankaccount which initializes the amount of the account
	 * at 0
	 */
	public Bankaccount() {
		this.amount = 0;
	}

	/**
	 * Constructor of a Bankaccount which initializes the amount of the account
	 * with the value given in parameters
	 * 
	 * @param amount
	 */
	public Bankaccount(double amount) {
		this.amount = amount;
	}

	/**
	 * Add the value given in parameters to the bankaccount
	 * 
	 * @param credit
	 *            Value that will be added to the account
	 */
	public void credit(double credit) {
		this.amount += credit;
	}

	/**
	 * Withdraw the value given in parameters from the bankaccount
	 * 
	 * @param debit
	 *            Value that will be withdrawn from the account
	 */
	public void debit(double debit) {
		this.amount -= debit;
	}

	public double getAmount() {
		return this.amount;
	}
}
