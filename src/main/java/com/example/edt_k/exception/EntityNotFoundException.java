package com.example.edt_k.exception;

import com.example.edt_k.entity.Duration;

public class EntityNotFoundException extends RuntimeException{
    //constructor
    public EntityNotFoundException(Long id, Class<?> entity) {
        super("The " + entity.getSimpleName().toLowerCase() + " with id '" + id + "' does not exist in our records");
    }
    public EntityNotFoundException(Duration examTime, Class<?> entity) {
        super("The " + entity.getSimpleName().toLowerCase() + " with this meeting time  " + examTime + " does not exist in our records");}
}

