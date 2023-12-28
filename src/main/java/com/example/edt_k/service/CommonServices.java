package com.example.edt_k.service;

public class CommonServices {
    public static int random_int(int start, int end) {
        return (int) ((end-start)*Math.random()+start);
    }
}
