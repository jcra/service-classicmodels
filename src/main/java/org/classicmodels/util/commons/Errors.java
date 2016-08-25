package org.classicmodels.util.commons;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Errors")
public class Errors {

    private ReturnCode code;
    private String message;
    private String exception;

    public ReturnCode getCode() {
        return code;
    }

    public void setCode(ReturnCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
