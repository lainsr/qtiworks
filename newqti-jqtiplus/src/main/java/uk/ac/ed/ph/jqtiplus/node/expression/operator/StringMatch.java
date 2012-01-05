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
package uk.ac.ed.ph.jqtiplus.node.expression.operator;

import uk.ac.ed.ph.jqtiplus.attribute.value.BooleanAttribute;
import uk.ac.ed.ph.jqtiplus.control.ProcessingContext;
import uk.ac.ed.ph.jqtiplus.node.expression.AbstractExpression;
import uk.ac.ed.ph.jqtiplus.node.expression.ExpressionParent;
import uk.ac.ed.ph.jqtiplus.value.BooleanValue;
import uk.ac.ed.ph.jqtiplus.value.NullValue;
import uk.ac.ed.ph.jqtiplus.value.StringValue;
import uk.ac.ed.ph.jqtiplus.value.Value;

/**
 * The stringMatch operator takes two sub-expressions which must have single and A base-type of string.
 * The result is A single boolean with A value of true if the two strings match according to the comparison
 * rules defined by the attributes below and false if they don't.
 * If either sub-expression is NULL then the operator results in NULL.
 * <p>
 * Attribute : caseSensitive [1]: boolean
 * <p>
 * Whether or not the match is to be carried out case sensitively.
 * <p>
 * Attribute : substring [0..1]: boolean = false
 * <p>
 * This attribute is now deprecated, the substring operator should be used instead. If true, then the comparison returns true if the first string contains the
 * second one, otherwise it returns true only if they match entirely.
 * 
 * @see uk.ac.ed.ph.jqtiplus.value.Cardinality
 * @see uk.ac.ed.ph.jqtiplus.value.BaseType
 * @see uk.ac.ed.ph.jqtiplus.node.expression.operator.Substring
 * @author Jiri Kajaba
 */
public class StringMatch extends AbstractExpression {

    private static final long serialVersionUID = 8495415247770053078L;

    /** Name of this class in xml schema. */
    public static final String CLASS_TAG = "stringMatch";

    /** Name of caseSensitive attribute in xml schema. */
    public static final String ATTR_CASE_SENSITIVE_NAME = "caseSensitive";

    /** Name of substring attribute in xml schema. */
    public static final String ATTR_SUBSTRING_NAME = "substring";

    /** Default value of substring attribute. */
    public static final boolean ATTR_SUBSTRING_DEFAULT_VALUE = false;

    /**
     * Constructs expression.
     * 
     * @param parent parent of this expression
     */
    public StringMatch(ExpressionParent parent) {
        super(parent);

        getAttributes().add(new BooleanAttribute(this, ATTR_CASE_SENSITIVE_NAME));
        getAttributes().add(new BooleanAttribute(this, ATTR_SUBSTRING_NAME, ATTR_SUBSTRING_DEFAULT_VALUE));
    }

    @Override
    public String getClassTag() {
        return CLASS_TAG;
    }

    /**
     * Gets value of caseSensitive attribute.
     * 
     * @return value of caseSensitive attribute
     * @see #setCaseSensitive
     */
    public Boolean getCaseSensitive() {
        return getAttributes().getBooleanAttribute(ATTR_CASE_SENSITIVE_NAME).getValue();
    }

    /**
     * Sets new value of caseSensitive attribute.
     * 
     * @param caseSensitive new value of caseSensitive attribute
     * @see #getCaseSensitive
     */
    public void setCaseSensitive(Boolean caseSensitive) {
        getAttributes().getBooleanAttribute(ATTR_CASE_SENSITIVE_NAME).setValue(caseSensitive);
    }

    /**
     * Gets value of substring attribute.
     * 
     * @return value of substring attribute
     * @see #setSubString
     */
    public Boolean getSubString() {
        return getAttributes().getBooleanAttribute(ATTR_SUBSTRING_NAME).getValue();
    }

    /**
     * Sets new value of substring attribute.
     * 
     * @param subString new value of substring attribute
     * @see #getSubString
     */
    public void setSubString(Boolean subString) {
        getAttributes().getBooleanAttribute(ATTR_SUBSTRING_NAME).setValue(subString);
    }

    @Override
    protected Value evaluateSelf(ProcessingContext context, int depth) {
        if (isAnyChildNull(context)) {
            return NullValue.INSTANCE;
        }

        String firstString = ((StringValue) getFirstChild().getValue(context)).stringValue();
        String secondString = ((StringValue) getSecondChild().getValue(context)).stringValue();

        Boolean result = null;

        if (!getSubString()) {
            if (getCaseSensitive()) {
                result = firstString.compareTo(secondString) == 0;
            }
            else {
                result = firstString.compareToIgnoreCase(secondString) == 0;
            }
        }
        else {
            if (!getCaseSensitive()) {
                firstString = firstString.toLowerCase();
                secondString = secondString.toLowerCase();
            }

            result = firstString.indexOf(secondString) != -1;
        }

        assert result != null;

        return BooleanValue.valueOf(result);
    }
}
