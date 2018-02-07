package com.codecool.krk.queue.customexception;

public class EmptyQueue extends Exception {
    public EmptyQueue() {
    }

    public EmptyQueue(String message) {
        super(message);
    }

    public EmptyQueue(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyQueue(Throwable cause) {
        super(cause);
    }

    public EmptyQueue(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
