package br.com.blecaute.store.exception.product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The product was not found")
public class ProductNotFoundException extends RuntimeException {}
