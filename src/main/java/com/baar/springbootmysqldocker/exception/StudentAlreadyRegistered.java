package com.baar.springbootmysqldocker.exception;

public class StudentAlreadyRegistered extends Throwable {
    public StudentAlreadyRegistered(String message) {
        super(message);
    }
}
