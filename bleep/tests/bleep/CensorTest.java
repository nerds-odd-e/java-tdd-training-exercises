package bleep;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("serial")
public class CensorTest {
	Censor censor = new Censor();

	@Before
	public void setup() {
		censor.setCensorStringList(defaultForbbidenWordsArrayList());
	}
	
	@Test
	public void testBlankString() {
		assertEquals("", censor.censor(""));
	}
	
	@Test
	public void testFrank() {
		assertEquals("F***k", censor.censor("Frank"));
	}
	
	@Test
	public void testFrankIgnoreCase() {
		assertEquals("f***k", censor.censor("frank"));
	}
	
	@Test
	public void testFrankWithFrankNotInList() {
		censor.setCensorStringList(new ArrayList<String>() {{add("Prank");}});
		assertEquals("Frank", censor.censor("Frank"));
	}
	
	@Test
	public void testFrankly() {
		assertEquals("Frankly", censor.censor("Frankly"));
	}

	@Test
	public void testFrankWithQuotes() {
		assertEquals("\"F***k", censor.censor("\"Frank"));
	}

	@Test
	public void testFrankWithPeriod() {
		assertEquals("F***k.", censor.censor("Frank."));
	}
	
	@Test
	public void testToBeFrankWithQuotes() {
		assertEquals("To be F***k", censor.censor("To be Frank"));
	}
	
	@Test
	public void testToBeFrankWithSpecialCharacter() {
		assertEquals("F***k\n", censor.censor("Frank\n"));
	}
	
	@Test
	public void testToBeFrankWithTwoWordsAndQuotes() {
		assertEquals("\"F***k ford\"", censor.censor("\"Frank ford\""));
	}

	private ArrayList<String> defaultForbbidenWordsArrayList() {
		return new ArrayList<String>() {{add("Frank");}};
	}
	
	@Test
	public void testMultipleCensorWords() {
		censor.setCensorStringList(new ArrayList<String>() {{
			add("Frank");
			add("seek");
			}});
		assertEquals("f***k s**k", censor.censor("frank seek"));
	}
	
	@Test
	public void testMultiwordCensor() {
		censor.setCensorStringList(new ArrayList<String>() {{add("brilliant job");}});
		assertEquals("Mike b******** **b", censor.censor("Mike brilliant job"));
	}
	
	@Test
	public void testMultiwordCensorWithNewline() {
		censor.setCensorStringList(new ArrayList<String>() {{add("brilliant\njob");}});
		assertEquals("Mike b********\n**b", censor.censor("Mike brilliant\njob"));
	}

	@Test @Ignore
	public void testNounsAndVerbs() {
		censor.setCensorStringList(new ArrayList<String>() {{add("frank");}});
		assertEquals("f***kked", censor.censor("frankked"));
	}
	
	@Test
	public void testMultipleCensorWords2() {
		String filtered = "Frankly asdfasdf frankly";
		Pattern p = Pattern.compile("(?i)(\\bFrankly\\b)");
	    Matcher m = p.matcher(filtered);
	    StringBuffer s = new StringBuffer();
	    while (m.find()){
	        System.out.print(m.group(0));
	        System.out.println();
	        System.out.print(getFilterStars(m.group()));
	        System.out.println();
	        for (int i=0; i<m.groupCount(); i++) {
	        	filtered = filtered.replaceAll(m.group(i), getFilterStars(m.group(i)));
	        }
	    }
        System.out.print(filtered);
	}
	
	public String getFilterStars(String censorVar) {
		String stars = censorVar.substring(0, 1);
		for(int i = 1;i<censorVar.length() -1;i++)
		{
			if (censorVar.charAt(i) == ' ' || censorVar.charAt(i) == '\n' )
				stars += censorVar.charAt(i);
			else
				stars += "*";
		}
		
		return stars + censorVar.substring(censorVar.length() - 1);
	}

}
