package pl.atipera.githubbrowser.api.error;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ApiError {
    private final HttpStatus status;
    private final String message;

    public ApiError(HttpStatus status, Throwable e) {
        this.status = status;
        this.message = e.getLocalizedMessage();
    }
}
