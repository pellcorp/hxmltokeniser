/*      
    HXML Tokeniser
    Copyright (C) 2001-2012 by Jason Pell

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.
    
    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.
    
    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  US
 */

package com.pellcorp.xml.parser;

import java.io.StringReader;
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
            if (parse.getTokenType() == HxmlTokeniser.START_TAG
                || parse.getTokenType() == HxmlTokeniser.EMPTY_TAG) {
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
