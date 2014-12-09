package letters;

/**
 * Interface for the content of the letters. Note that the letters can be
 * composed by only one type of content
 * 
 * @author Thomas OSTROWSKI
 */

public interface Content {

	/**
	 * Gives a description of the content
	 * @return a description of the content
	 */
	public String getDescription();

	/**
	 * Returns the value of the content 
	 * @return the real value of the content
	 */
	public String toString();
}
