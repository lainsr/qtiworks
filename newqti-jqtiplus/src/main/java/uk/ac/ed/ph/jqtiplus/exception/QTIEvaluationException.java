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
package uk.ac.ed.ph.jqtiplus.exception;

/**
 * This exception is used for propagating errors during execution of assessment.
 * Preferred way is to use more concrete exception (see sub-classes of this exception).
 * 
 * @author Jiri Kajaba
 */
public class QTIEvaluationException extends QTIRuntimeException {

    private static final long serialVersionUID = 2827334569953049498L;

    /**
     * Constructs A new exception with <code>null</code> as its detailed message.
     */
    protected QTIEvaluationException() {
        super();
    }

    /**
     * Constructs A new exception with the specified detailed message.
     * 
     * @param message the detail message
     */
    public QTIEvaluationException(String message) {
        super(message);
    }

    /**
     * Constructs A new exception with the specified detailed message and cause.
     * 
     * @param message the detail message
     * @param cause the cause
     */
    public QTIEvaluationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs A new exception with the specified cause.
     * If cause is not <code>null</code> detailed message is set from this cause.
     * 
     * @param cause the cause
     */
    public QTIEvaluationException(Throwable cause) {
        super(cause);
    }
}
