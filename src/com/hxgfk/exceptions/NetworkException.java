package com.hxgfk.exceptions;

public class NetworkException extends Exception{
    public NetworkException(){}

    public NetworkException(String messgae){
        super(messgae);
    }

    public NetworkException(Throwable cause){
        super(cause);
    }
}
