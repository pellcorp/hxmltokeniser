package com.pellcorp.xml.parser;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class HxmlTokeniserTest {
	@Test
	public void testReader() throws Exception {
		String template = "<*Date type=\"xxxx\"><year-to-date>*</year-to-date><month>*</month><day>*</day></*Date>";

		HxmlTokeniser parse = new HxmlTokeniser(new StringReader(template));
		
		while (parse.nextToken()) {
			
		}
	}
	
	@Test
	public void testReadAttributes() throws Exception {
		String template = "<dateOfBirth>\n" + 
				"	      		<date>\n" + 
				"		      <year>${year}</year>\n" + 
				"		      <month>${month}</month>\n" + 
				"		      <day>${day}</day>\n" + 
				"	          <invalidValue></invalidValue>\n" + 
				"		      </date>\n" + 
				"		    </dateOfBirth>";
		
		List<String> startTags = new ArrayList<String>();
		
		HxmlTokeniser parse = new HxmlTokeniser(new StringReader(template));
		while (parse.nextToken()) {
			if (parse.getTokenType() == HxmlTokeniser.START_TAG || parse.getTokenType() == HxmlTokeniser.EMPTY_TAG) {
				startTags.add(parse.getTokenName());
			}
		}
		
		assertEquals(6, startTags.size());
	}
}
