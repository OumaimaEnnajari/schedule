package com.example.edt_k.exception;

import com.example.edt_k.entity.Exam_time;

public class EntityNotFoundException extends RuntimeException{
    //constructor
    public EntityNotFoundException(Exam_time examTime, Class<?> entity) {
        super("The " + entity.getSimpleName().toLowerCase() + " with this meeting time  " + examTime + " does not exist in our records");
    }
}
