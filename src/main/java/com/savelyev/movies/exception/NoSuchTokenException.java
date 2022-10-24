package com.savelyev.movies.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoSuchTokenException extends RuntimeException {
    public NoSuchTokenException(String message) {
        super(message);
    }
}
