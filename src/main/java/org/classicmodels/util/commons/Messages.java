package org.classicmodels.util.commons;

import java.lang.reflect.Field;
import java.text.MessageFormat;

public class Messages {

    /** A message similar to "An unexpected error has occurred" */
    public static final String ERR_UNEXPECTED = "An unexpected error has occurred.";

    /** A message similar to "Field '{0}' is required" */
    public static final String ERR_REQUIRED_FIELD = "Field ''{0}'' is required.";

    /** A message similar to "A request parameter contains invalid characters or is formatted incorrectly." */
    public static final String ERR_INVALID_INPUT = "A request parameter contains invalid characters or is formatted incorrectly.";

    /** A message similar to "The service is currently down for maintenance" */
    public static final String ERR_DOWN_FOR_MAINTENANCE = "The service is currently down for maintenance.";

    /** A message similar to "No content was returned" */
    public static final String ERR_NO_CONTENT = "No content was returned.";

    /** A message similar to "No record was found for {0} : {1}" */
    public static final String ERR_RECORD_NOT_FOUND = "No record was found for ''{0}'' : ''{1}'' ";

    /** A message similar to "The resource requested was not found." */
    public static final String ERR_NOT_FOUND = "The resource requested was not found.";


    /**
     * Gets the message with the specified key.
     *
     * @param key the key of the message.
     * @return the message if it exists, the {@code key} other wise
     */
    public static String get(String key) {

        String msg;

        try {
            Field f = Messages.class.getField(key);
            msg = (String)f.get(null);
        }
        catch(NoSuchFieldException ex) {
            System.out.println(String.format("No message found for key {0}", key));
            msg = key;
        }
        catch(Exception ex) {
            System.out.println(String.format("Could not retrieve message for key {0}", key));
            msg = key;
        }

        return msg;
    }


    /**
     * Returns a string formatted with the provided replacements.
     *
     * @param message 	the message string format.
     * @param args		the objects to format the message with.
     * @see MessageFormat#format(String, Object...)
     * @return the string
     */
    public static String format(String message, Object... args) {

        return MessageFormat.format(message, args);
    }

    /**
     * Hide constructor (static class)
     */
    private Messages() { }


}
