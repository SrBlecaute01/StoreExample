package br.com.blecaute.store.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@NoArgsConstructor
public class StoreExceptionHandler {

/*
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException exception) {
        StoreExceptionResponse response = new StoreExceptionResponse(HttpStatus.BAD_REQUEST, "Validation failed");
        exception.getBindingResult().getAllErrors().forEach(error ->
                response.addCause(new StoreExceptionResponse.Cause(error.getDefaultMessage())));

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
*/

}
