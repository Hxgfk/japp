package com.hxgfk.exceptions;

public class AnnotationException extends Exception{
    public AnnotationException(){
        super();
    }

    public AnnotationException(String message){
        super(message);
    }

    public AnnotationException(Throwable cause){
        super(cause);
    }
}
