package com.codewithlfn.shopbackend.exception;

import com.codewithlfn.shopbackend.dto.response.GenericMessageResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Slf4j
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    private final View error;

    public ControllerAdvisor(View error) {
        this.error = error;
    }

    // Convert list of ObjectErrors to a friendly message
    private static String toFriendlyMessage(final List<ObjectError> errors) {
        final List<String> errorMessages = new ArrayList<>();
        errors.forEach(e -> errorMessages.add(e.getDefaultMessage()));
        return String.join(" | ", errorMessages);
    }

    // Handle validation exceptions for request bodies
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            @NonNull MethodArgumentNotValidException e,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatusCode status,
            @NonNull WebRequest req) {

        var message = toFriendlyMessage(e.getBindingResult().getAllErrors());
        var error = GenericMessageResponse.builder()
                .message(message)
                .build();
        return ResponseEntity.badRequest().body(error);
    }

    // Handle validation exceptions for method parameters
    @Override
    protected ResponseEntity<Object> handleHandlerMethodValidationException(
            HandlerMethodValidationException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        String errorMessage = null;
        for (var parameterValidationResult : ex.getParameterValidationResults()) {
            for (var messageSourceResolvable : parameterValidationResult.getResolvableErrors()) {
                if (errorMessage == null) {
                    errorMessage = messageSourceResolvable.getDefaultMessage();
                } else {
                    errorMessage = String.format("%s | %s", errorMessage, messageSourceResolvable.getDefaultMessage());
                }
            }
        }
        var error = GenericMessageResponse.builder()
                .message(errorMessage)
                .build();
        return ResponseEntity.badRequest().body(error);
    }

    // Handle other runtime exceptions
    @ExceptionHandler({RuntimeException.class})
    public final ResponseEntity<Object> handleTimeOutException(final Exception ex) {
        var error = GenericMessageResponse.builder()
                .message(ex.getMessage())
                .build();
        return ResponseEntity.badRequest().body(error);
    }


}
