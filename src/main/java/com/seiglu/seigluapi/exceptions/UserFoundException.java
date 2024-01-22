package com.seiglu.seigluapi.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("User already exist");
    }
}
