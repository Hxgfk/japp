package com.hxgfk.exceptions;

public class SQLDriverMissingException extends Exception{
    public SQLDriverMissingException(){}

    public SQLDriverMissingException(String message){
        super(message);
    }

    public SQLDriverMissingException(Throwable cause){
        super(cause);
    }
}
