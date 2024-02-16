package pl.atipera.githubbrowser.error.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import pl.atipera.githubbrowser.error.ApiError;
import pl.atipera.githubbrowser.error.exception.UserNotFoundException;

@RestControllerAdvice
public class ApiErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<?> handleUserNotFound(UserNotFoundException e) {
        return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, e));
    }

    private static ResponseEntity<?> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
