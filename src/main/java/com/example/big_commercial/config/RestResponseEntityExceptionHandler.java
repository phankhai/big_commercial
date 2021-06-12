package com.example.big_commercial.config;

import com.example.big_commercial.dto.ErrorDTO;
import com.example.big_commercial.enums.ErrorCodeMap;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;

@ControllerAdvice(assignableTypes = RestController.class)
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<Object> handleAccessDeniedException(
            Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                "Access denied message here", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = { ProductNotfoundException.class})
    public ResponseEntity<Object> exception(ProductNotfoundException ex, WebRequest request) {
        ErrorCodeMap errorCode = ErrorCodeMap.valueOf(ex.getErrorKey());
        if (errorCode == null) {
            errorCode = ErrorCodeMap.FAILURE_EXCEPTION;
        }
        ErrorDTO error = new ErrorDTO();
        error.setErrorNo(errorCode.getValue());
        error.setErrorCode(errorCode.name());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { BadRequestException.class})
    public ResponseEntity<Object> handleBadRequest(BadRequestException ex, WebRequest request) {
        ErrorCodeMap errorCode = ErrorCodeMap.valueOf(ex.getErrorKey());
        if (errorCode == null) {
            errorCode = ErrorCodeMap.FAILURE_EXCEPTION;
        }
        ErrorDTO error = new ErrorDTO();
        error.setErrorNo(errorCode.getValue());
        error.setErrorCode(errorCode.name());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { EmailException.class })
    public ResponseEntity<Object> handleEmailException(EmailException ex) {
        return new ResponseEntity<Object>("Email invalid", HttpStatus.BAD_REQUEST);
    }

}
