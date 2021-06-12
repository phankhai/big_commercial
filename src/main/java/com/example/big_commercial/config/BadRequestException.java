package com.example.big_commercial.config;

import com.example.big_commercial.constant.ErrorConstants;
import org.springframework.validation.FieldError;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class BadRequestException extends AbstractThrowableProblem {

    private static final long serialVersionUID = 1L;

    private String errorKey;

    public BadRequestException(FieldError fieldError) {
        super(ErrorConstants.BAD_REQUEST_TYPE, fieldError.getCode(), Status.BAD_REQUEST);
        this.errorKey = fieldError.getCode();
    }
    public BadRequestException(String errorKey) {
        super(ErrorConstants.BAD_REQUEST_TYPE, errorKey, Status.BAD_REQUEST);
        this.errorKey = errorKey;
    }

    public String getErrorKey() {
        return errorKey;
    }

}
