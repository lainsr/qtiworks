/* Copyright (c) 2012, University of Edinburgh.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice, this
 *   list of conditions and the following disclaimer in the documentation and/or
 *   other materials provided with the distribution.
 *
 * * Neither the name of the University of Edinburgh nor the names of its
 *   contributors may be used to endorse or promote products derived from this
 *   software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *
 * This software is derived from (and contains code from) QTItools and MathAssessEngine.
 * QTItools is (c) 2008, University of Southampton.
 * MathAssessEngine is (c) 2010, University of Edinburgh.
 */
package uk.ac.ed.ph.jqtiplus.value;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests <code>UriValue</code> implementation of parsing value from <code>String</code>.
 * <p>
 * This test contains only valid <code>String</code> representations.
 * 
 * @see uk.ac.ed.ph.jqtiplus.value.UriValue
 * @see java.net.URI
 */
@RunWith(Parameterized.class)
public class UriValueAcceptTest {

    /**
     * Creates test data for this test.
     * 
     * @return test data for this test
     */
    @Parameters
    public static Collection<Object[]> data() {
        try {
            return Arrays.asList(new Object[][] { { "http://www.example.com/", new URI("http://www.example.com/") },
                    { "images/icon.gif", new URI("images/icon.gif") }, { "mailto:user@example.com", new URI("mailto:user@example.com") },
            });
        }
        catch (final URISyntaxException ex) {
            throw new RuntimeException(ex);
        }
    }

    private final String string;

    private final URI expectedUri;

    /**
     * Constructs this test.
     * 
     * @param string parsed <code>String</code>
     * @param expectedUri expected parsed value
     */
    public UriValueAcceptTest(String string, URI expectedUri) {
        this.string = string;
        this.expectedUri = expectedUri;
    }

    /**
     * Tests parsing value from <code>String</code> representation.
     */
    @Test
    public void testParseUri() {
        assertEquals(expectedUri, UriValue.parseUri(string));
    }
}
