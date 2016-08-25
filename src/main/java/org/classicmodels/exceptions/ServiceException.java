package org.classicmodels.exceptions;

import org.classicmodels.util.commons.ReturnCode;

import java.lang.reflect.Field;
import java.text.MessageFormat;

public class ServiceException extends Exception {

    private static final long serialVersionUID = -6546879132131645L;

    private ReturnCode code;

    public ServiceException() {

        super();
    }


    public ServiceException(ReturnCode code) {

        this(code, code.defaultMessage());
    }


    public ServiceException(ReturnCode code, String message) {

        this(code, message, (Throwable)null);
    }


    public ServiceException(ReturnCode code, Throwable cause) {

        this(code, code.defaultMessage(), cause);
    }


    public ServiceException(ReturnCode code, String message, Throwable cause) {

        super(message, cause);
        this.code = code;
    }


    public ServiceException(ReturnCode code, String message, Object... args) {

        this(code, null, message, args);
    }


    public ServiceException(ReturnCode code, Throwable cause, String message, Object... args) {
        super(MessageFormat.format(message, args), cause);
        this.code = code;
    }


    public ReturnCode getCode() {
        return code;
    }

    public void setCode(ReturnCode code) {
        this.code = code;
    }

    @Override
    public String getMessage() {

        String result = super.getMessage();
        Throwable e = this;
        while (e.getCause() != null) {
            e = e.getCause();
            if(e.getMessage() != null && !e.getMessage().equals("null")) {
                result += "\n" + e.getMessage();
            }
            else {
                // If the Throwable message is null, this might be a vendor API exception, so try to get the message
                // from the isMessage field. This field is sometimes populated or vendor API exceptions even when the
                // Throwable message property is blank
                try {
                    Field f = e.getClass().getField("isMessage");
                    String msg = (String)f.get(e);
                    if(msg != null) {
                        result += "\n" + msg;
                    }
                }
                catch(Exception nfex) {
                    // No action
                }
            }
        }

        return result;
    }

}
