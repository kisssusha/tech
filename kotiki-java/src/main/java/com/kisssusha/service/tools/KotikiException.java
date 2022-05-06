package com.kisssusha.service.tools;

public class KotikiException extends Exception {
    public KotikiException() {
        super();
    }

    public KotikiException(String message) {
        super(message);
    }

    public KotikiException(String message, Throwable cause) {
        super(message, cause);

    }
}
