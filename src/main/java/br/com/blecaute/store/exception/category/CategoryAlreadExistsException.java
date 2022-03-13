package br.com.blecaute.store.exception.category;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "The category already exists")
public class CategoryAlreadExistsException extends RuntimeException { }
