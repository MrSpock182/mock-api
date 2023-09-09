package io.github.mrspock182.mockapi.resource.advice;

import io.github.mrspock182.mockapi.exception.ApplicationErrorException;
import io.github.mrspock182.mockapi.exception.NotFoundException;
import io.github.mrspock182.mockapi.resource.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class HandlerExceptionAdvice {
    private static final Logger log = LogManager.getLogger(HandlerExceptionAdvice.class);

    @ResponseBody
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class, ApplicationErrorException.class})
    public ErrorResponse handleErrorNotMap(
            final Exception exception,
            final HttpServletRequest request
    ) {
        String error = "Request: " + request + " Error: " + exception;
        log.error(error);
        return new ErrorResponse(
                LocalDateTime.now(),
                request.getServletPath(),
                INTERNAL_SERVER_ERROR.value(),
                INTERNAL_SERVER_ERROR.getReasonPhrase(),
                exception.getMessage()
        );
    }

    @ResponseBody
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    public ErrorResponse handleNotFound(
            final NotFoundException exception,
            final HttpServletRequest request
    ) {
        return new ErrorResponse(
                LocalDateTime.now(),
                request.getServletPath(),
                NOT_FOUND.value(),
                NOT_FOUND.getReasonPhrase(),
                exception.getMessage()
        );
    }

    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class})
    public ErrorResponse handleBadRequest(
            final IllegalArgumentException exception,
            final HttpServletRequest request
    ) {
        return new ErrorResponse(
                LocalDateTime.now(),
                request.getServletPath(),
                BAD_REQUEST.value(),
                BAD_REQUEST.getReasonPhrase(),
                exception.getMessage()
        );
    }
}
