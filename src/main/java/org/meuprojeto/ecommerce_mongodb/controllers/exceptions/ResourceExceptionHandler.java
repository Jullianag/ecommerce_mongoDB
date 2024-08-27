package org.meuprojeto.ecommerce_mongodb.controllers.exceptions;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.meuprojeto.ecommerce_mongodb.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), status.value(), "Resource not found", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);

    }
}
