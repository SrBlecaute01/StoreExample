package br.com.blecaute.store.exception.order;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The order was not found")
public class OrderNotFoundException extends RuntimeException{ }
