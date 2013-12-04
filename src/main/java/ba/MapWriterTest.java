package ba;

import static org.junit.Assert.*;

import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;

public class MapWriterTest {

	@Test
	public void test() {
		
		String ours[10][10] = new String()[10][10]; 
		String theirs[10][10] = new String()[10][10];
		MapWriter.print(ours, theirs);
	}
}
