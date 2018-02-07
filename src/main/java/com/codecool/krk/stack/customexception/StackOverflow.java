package com.codecool.krk.stack.customexception;

public class StackOverflow extends Exception{
    public StackOverflow() {
    }

    public StackOverflow(String message) {
        super(message);
    }

    public StackOverflow(String message, Throwable cause) {
        super(message, cause);
    }

    public StackOverflow(Throwable cause) {
        super(cause);
    }

    public StackOverflow(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
