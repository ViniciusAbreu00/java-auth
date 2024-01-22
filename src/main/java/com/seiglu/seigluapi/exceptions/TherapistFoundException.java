package com.seiglu.seigluapi.exceptions;

public class TherapistFoundException extends RuntimeException {
    public TherapistFoundException() {
        super("Therapist already exist");
    }
}
