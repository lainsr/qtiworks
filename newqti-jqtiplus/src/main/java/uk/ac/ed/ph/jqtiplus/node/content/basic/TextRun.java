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
package uk.ac.ed.ph.jqtiplus.node.content.basic;

import uk.ac.ed.ph.jqtiplus.node.AbstractNode;
import uk.ac.ed.ph.jqtiplus.node.XmlNode;
import uk.ac.ed.ph.jqtiplus.node.content.variable.TextOrVariable;

import org.w3c.dom.Text;

/**
 * Text content block. Contains only text content and no children.
 * 
 * @author Jonathon Hare
 */
public class TextRun extends AbstractNode implements FlowStatic, InlineStatic, TextOrVariable {

    private static final long serialVersionUID = -8609122687264674305L;

    /** Display name of this class. */
    public static String DISPLAY_NAME = "textRun";

    /** Text content of this block. */
    private String textContent;

    /**
     * Constructs block.
     * 
     * @param parent parent of this block
     * @param textContent text content of this block
     */
    public TextRun(XmlNode parent, String textContent) {
        super(parent);

        this.textContent = textContent;
    }

    @Override
    public String getClassTag() {
        return DISPLAY_NAME;
    }

    /**
     * Gets text content of this block.
     * 
     * @return text content of this block
     */
    public String getTextContent() {
        return textContent;
    }

    @Override
    public String toXmlString(int depth, boolean printDefaultAttributes) {
        return NEW_LINE + getIndent(depth) + escapeForXmlString(textContent, false);
    }

    public void load(Text sourceNode) {
        textContent = sourceNode.getTextContent();
    }

}
