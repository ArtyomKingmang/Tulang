package com.kingmang.tulang.exception;

public class TuException extends RuntimeException {

    public TuException(String message) {
        super("Tulang exception: ".concat(message));
    }

    public TuException(Throwable e) {
        super("Tulang exception: " + e);
    }
}
