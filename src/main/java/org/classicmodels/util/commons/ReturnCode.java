package org.classicmodels.util.commons;

import java.lang.reflect.Field;

public enum ReturnCode {

    /** The requested method completed as expected. */
    OK,

    /** An unexpected error occurred. */
    ERR_UNEXPECTED,

    /** A required field was not supplied. */
    ERR_REQUIRED_FIELD,

    /** Invalid character(s) were provided. */
    ERR_INVALID_INPUT,

    /** The request could not be completed because the system is down for maintenance */
    ERR_DOWN_FOR_MAINTENANCE,

    /** No content was returned */
    ERR_NO_CONTENT,

    /** The resource requested was not found */
    ERR_NOT_FOUND,

    /** No record was found for a submitted parameter */
    ERR_RECORD_NOT_FOUND;


    /**
     * Returns the default message associated with this return code.
     *
     * <p><b>Note:</b> The {@link #defaultMessage} for each return code is attempted to be retrieved
     * from the {@link Messages} class as the value of the field with the same name. If no field with the name of the
     * return code exists in the {@code Messages} class, an empty string will be returned.</p>
     *
     * @return the default message if defined, an empty string otherwise
     */
    public String defaultMessage() {

        String msg = "";

        try {
            Field f = Messages.class.getField(name());
            msg = (String)f.get(null);
        }
        catch(NoSuchFieldException ex) {
            System.out.println(String.format("No default message defined for return code {0}", name()));
        }
        catch(Exception ex) {
            System.out.println(String.format("Could not retrieve default message for return code {0}", name()));
        }

        return msg;
    }
}
