package com.app.rest.mobileappws.exception;

import com.app.rest.mobileappws.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value={Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {

        return handleException(ex);
    }

    private ResponseEntity<Object> handleException(Exception ex) {
        String errMsg = ex.getLocalizedMessage();

        if(errMsg==null) {
            errMsg = ex.toString();
        }

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setDate(new Date());
        errorMessage.setMsg(errMsg);
        errorMessage.setOccurredAt(Arrays.stream(ex.getStackTrace()).findFirst().get().toString());

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(value={NullPointerException.class, CustomException.class})
    public ResponseEntity<Object> handleNullPointerException(Exception ex, WebRequest request) {

        return handleException(ex);
    }

}
