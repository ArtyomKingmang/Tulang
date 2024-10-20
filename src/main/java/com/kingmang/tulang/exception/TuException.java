package com.kingmang.tulang.exception;

public class TuException extends RuntimeException {

    public TuException(String message) {
        super("Compiler exception: ".concat(message));
    }

    public TuException(Throwable e) {
        super("Compiler exception: " + e);
    }
}
