package com.example.demo.error;

public class GamesNotFoundException extends Exception {
    public GamesNotFoundException() {
        super();
    }

    public GamesNotFoundException(String message) {
        super(message);
    }

    public GamesNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public GamesNotFoundException(Throwable cause) {
        super(cause);
    }

    protected GamesNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
