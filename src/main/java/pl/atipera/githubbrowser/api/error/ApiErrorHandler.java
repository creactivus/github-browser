package pl.atipera.githubbrowser.api.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import pl.atipera.githubbrowser.exception.UserNotFoundException;

@RestControllerAdvice
public class ApiErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<?> handleUserNotFound(UserNotFoundException e) {
        return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, e));
    }

    private ResponseEntity<?> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
