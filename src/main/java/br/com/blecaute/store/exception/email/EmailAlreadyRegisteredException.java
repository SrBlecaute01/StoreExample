package br.com.blecaute.store.exception.email;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "The email has already been registered")
public class EmailAlreadyRegisteredException extends RuntimeException {

    public EmailAlreadyRegisteredException() {
        super();
    }

    public EmailAlreadyRegisteredException(String message) {
        super(message);
    }

}
