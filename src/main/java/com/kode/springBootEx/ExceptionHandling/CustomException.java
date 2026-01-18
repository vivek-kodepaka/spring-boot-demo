package com.kode.springBootEx.ExceptionHandling;

public class CustomException extends RuntimeException{
    public CustomException(String msg){
        super(msg);
    }
}
