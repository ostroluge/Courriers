package lettersT;

import static org.junit.Assert.*;
import letters.Text;

import org.junit.Test;

public class TextTest {

	@Test
	public void testTextInitialization() {
		Text text = new Text("bla bla");
		assertEquals(text.getDescription(), "text content");
		assertEquals(text.toString(), "bla bla");
	}
}
