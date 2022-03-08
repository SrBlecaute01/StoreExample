package br.com.blecaute.store.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
public class StoreExceptionResponse {

    private final Date timestamp = new Date();
    private final HttpStatus status;
    private final String message;
    private final List<Cause> cause = new ArrayList<>();

    public StoreExceptionResponse(HttpStatus status, Exception exception) {
        this.status = status;
        this.message = exception.getLocalizedMessage();
    }

    public void addCause(Cause cause) {
        this.cause.add(cause);
    }

    @AllArgsConstructor
    @Data
    public static class Cause {

        private final String description;

    }

}
