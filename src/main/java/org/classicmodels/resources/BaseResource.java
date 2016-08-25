package org.classicmodels.resources;

import org.classicmodels.exceptions.ServiceException;
import org.classicmodels.exceptions.UserCausedException;
import org.classicmodels.util.commons.Errors;
import org.classicmodels.util.commons.ReturnCode;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.transaction.TransactionSystemException;

import javax.ws.rs.core.Response;

public class BaseResource {

    protected Response onException(Exception e){

        Errors errors = new Errors();

        Response.Status status = Response.Status.OK;

        if(e instanceof TransactionSystemException){
            TransactionSystemException tex  = (TransactionSystemException) e;

            if(tex.getApplicationException() instanceof UserCausedException){

                UserCausedException uex = (UserCausedException) tex.getApplicationException();

                status = Response.Status.BAD_REQUEST;

                errors.setMessage(uex.getMessage());
                errors.setCode(uex.getCode());
                errors.setException(uex.getClass().getSimpleName());

            } else if(tex.getApplicationException() instanceof ServiceException){

                ServiceException sex = (ServiceException) tex.getApplicationException().getCause().getCause();

                status = Response.Status.INTERNAL_SERVER_ERROR;

                errors.setMessage(sex.getMessage());
                errors.setCode(sex.getCode());
                errors.setException(sex.getClass().getSimpleName());

            }

        }  else if(e instanceof UserCausedException || e instanceof ServiceException){

            ServiceException ex = (ServiceException) e;

            switch (ex.getCode()){
                case ERR_NOT_FOUND:
                case ERR_RECORD_NOT_FOUND:
                    status = Response.Status.NOT_FOUND;
                    break;
                case ERR_REQUIRED_FIELD:
                    status = Response.Status.BAD_REQUEST;
                    break;
                case ERR_INVALID_INPUT:
                    status = Response.Status.BAD_REQUEST;
                    break;
                default:
                    status = Response.Status.INTERNAL_SERVER_ERROR;
            }

            errors.setMessage(ex.getMessage());
            errors.setCode(ex.getCode());
            errors.setException(ex.getClass().getSimpleName());

        }  else if(e instanceof NullPointerException){

            status = Response.Status.BAD_REQUEST;

            errors.setMessage(e.getMessage());
            errors.setCode(ReturnCode.ERR_INVALID_INPUT);
            errors.setException(e.getClass().getSimpleName());

        }else{

            status = Response.Status.INTERNAL_SERVER_ERROR;

            errors.setMessage(e.getMessage());
            errors.setCode(ReturnCode.ERR_UNEXPECTED);
            errors.setException(e.getClass().getSimpleName());

        }


        return Response.status(status).entity(errors).build();

    }
}
