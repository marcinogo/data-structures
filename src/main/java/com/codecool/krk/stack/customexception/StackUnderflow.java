package com.codecool.krk.stack.customexception;

public class StackUnderflow extends Exception{
    public StackUnderflow() {
    }

    public StackUnderflow(String message) {
        super(message);
    }

    public StackUnderflow(String message, Throwable cause) {
        super(message, cause);
    }

    public StackUnderflow(Throwable cause) {
        super(cause);
    }

    public StackUnderflow(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
