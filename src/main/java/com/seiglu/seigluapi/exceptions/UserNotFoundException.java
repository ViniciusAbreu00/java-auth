package com.seiglu.seigluapi.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
            super("User not found");
        }

}
