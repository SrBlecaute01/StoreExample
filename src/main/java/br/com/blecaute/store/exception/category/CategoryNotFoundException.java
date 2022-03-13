package br.com.blecaute.store.exception.category;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The category was not found")
public class CategoryNotFoundException extends RuntimeException {}
