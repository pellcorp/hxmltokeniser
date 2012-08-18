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
		String template = "<*Date Year=\"${year}\" Month=\"${month}\" Day=\"${day}\" InvalidValue=\"\" />";
		
		HxmlTokeniser parse = new HxmlTokeniser(new StringReader(template));
		while (parse.nextToken()) {
			if (parse.getTokenType() == HxmlTokeniser.START_TAG || parse.getTokenType() == HxmlTokeniser.EMPTY_TAG) {
				List<Attribute> attributeList = parse.getAttributes();
				assertEquals(4, attributeList.size());
				assertEquals("Year", attributeList.get(0).getName());
				assertEquals("Month", attributeList.get(1).getName());
				assertEquals("Day", attributeList.get(2).getName());
				assertEquals("InvalidValue", attributeList.get(3).getName());
			}
		}
	}
}
