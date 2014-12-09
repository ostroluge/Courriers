package letters;

/**
 * Class which defines the text content that can be added to a SimpleLetter
 * 
 * @author Thomas OSTROWSKI
 *
 */
public class Text implements Content {

	protected String text;

	/**
	 * Constructor of a Text content that is initialized with the text given in
	 * parameters
	 * 
	 * @param text
	 *            Value of the text content
	 */
	public Text(String text) {
		this.text = text;
	}

	public String getDescription() {
		return "text content";
	}

	public String toString() {
		String s = "";
		s += this.text;
		return s;
	}
}
