package com.chromeinfotech.ui.Exception;

/**
 * myException is  custom exception which extends Exception
 */

public class myException extends Exception {
    public myException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
