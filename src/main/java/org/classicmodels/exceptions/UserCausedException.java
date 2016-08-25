package org.classicmodels.exceptions;

import org.classicmodels.util.commons.ReturnCode;

public class UserCausedException extends ServiceException {

    private static final long serialVersionUID = 6464198162135498L;


    public UserCausedException() {

        super();
    }

    public UserCausedException(ReturnCode code) {

        super(code);
    }

    public UserCausedException(ReturnCode code, String message) {

        super(code, message);
    }

    public UserCausedException(ReturnCode code, Throwable cause) {

        super(code, cause);
    }

    public UserCausedException(ReturnCode code, String message, Throwable cause) {

        super(code, message, cause);
    }

    public UserCausedException(ReturnCode code, String message, Object... args) {

        super(code, message, args);
    }

    public UserCausedException(ReturnCode code, Throwable cause, String message, Object... args) {

        super(code, cause, message, args);
    }
}
