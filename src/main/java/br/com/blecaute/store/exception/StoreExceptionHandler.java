package br.com.blecaute.store.exception;

import br.com.blecaute.store.exception.email.EmailAlreadyRegisteredException;
import br.com.blecaute.store.exception.user.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@AllArgsConstructor
public class StoreExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception) {
        StoreExceptionResponse response = new StoreExceptionResponse(HttpStatus.NOT_FOUND, exception);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailAlreadyRegisteredException.class)
    public ResponseEntity<Object> handleEmailException(EmailAlreadyRegisteredException exception) {
        StoreExceptionResponse response = new StoreExceptionResponse(HttpStatus.CONFLICT, exception);
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException exception) {
        StoreExceptionResponse response = new StoreExceptionResponse(HttpStatus.BAD_REQUEST, exception);
        exception.getBindingResult().getAllErrors().forEach(error ->
                response.addCause(new StoreExceptionResponse.Cause(error.getDefaultMessage())));

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
