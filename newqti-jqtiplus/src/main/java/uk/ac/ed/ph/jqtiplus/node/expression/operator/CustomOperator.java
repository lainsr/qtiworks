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

import uk.ac.ed.ph.jqtiplus.attribute.value.StringAttribute;
import uk.ac.ed.ph.jqtiplus.attribute.value.UriAttribute;
import uk.ac.ed.ph.jqtiplus.control.JQTIExtensionPackage;
import uk.ac.ed.ph.jqtiplus.node.expression.AbstractExpression;
import uk.ac.ed.ph.jqtiplus.node.expression.ExpressionParent;

import java.net.URI;

/**
 * The custom operator provides an extension mechanism for defining operations not currently supported
 * by this specification.
 * <p>
 * use the class attr to point to A java class (fully qualified) that implements Expression (and possibly extends AbstractExpression). If you do extend
 * AbstractExpression, set the CLASS_TAG to "customOperator", or override relevant methods required for validation that might call getType() to stop
 * unsupportedExpression exceptions at runtime.
 * 
 * @author Jonathon Hare
 */
public abstract class CustomOperator extends AbstractExpression {

    private static final long serialVersionUID = -3800871694273961417L;

    /** Name of this class in xml schema. */
    public static final String CLASS_TAG = "customOperator";

    /** Name of the class attribute in xml schema. */
    public static final String ATTR_CLASS_NAME = "class";

    /** Name of the definition attribute in xml schema. */
    public static final String ATTR_DEFINITION_NAME = "definition";

    /** The {@link JQTIExtensionPackage} that defines this operator */
    private JQTIExtensionPackage jqtiExtensionPackage;

    /**
     * Constructs expression.
     * 
     * @param parent parent of this expression
     */
    protected CustomOperator(JQTIExtensionPackage jqtiExtensionPackage, ExpressionParent parent) {
        super(parent);
        this.jqtiExtensionPackage = jqtiExtensionPackage;
        getAttributes().add(new StringAttribute(this, ATTR_CLASS_NAME, null, null, false)); //allow .'s, so use String
        getAttributes().add(new UriAttribute(this, ATTR_DEFINITION_NAME, null, null, false));
    }

    @Override
    public String getClassTag() {
        return CLASS_TAG;
    }

    public JQTIExtensionPackage getJQTIExtensionPackage() {
        return jqtiExtensionPackage;
    }

    public void setJQTIExtensionPackage(JQTIExtensionPackage jqtiExtensionPackage) {
        this.jqtiExtensionPackage = jqtiExtensionPackage;
    }

    /**
     * Gets value of class attribute.
     * 
     * @return value of class attribute
     */
    public String getClassAttr() {
        return getAttributes().getStringAttribute(ATTR_CLASS_NAME).getValue();
    }

    /**
     * Sets value of class attribute.
     * 
     * @return value of class attribute
     */
    public void setClassAttr(String name) {
        getAttributes().getStringAttribute(ATTR_CLASS_NAME).setValue(name);
    }

    /**
     * Gets value of definition attribute.
     * 
     * @return value of definition attribute
     */
    public URI getDefinition() {
        return getAttributes().getUriAttribute(ATTR_DEFINITION_NAME).getValue();
    }

    /**
     * Sets value of definition attribute.
     * 
     * @return value of definition attribute
     */
    public void setDefinition(URI name) {
        getAttributes().getUriAttribute(ATTR_DEFINITION_NAME).setValue(name);
    }

    @Override
    public boolean isVariable() {
        return true;
    }
}
