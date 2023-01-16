package com.hxgfk.util;

import com.hxgfk.annotations.DisplayDebugData;
import com.hxgfk.exceptions.AnnotationException;

import java.util.Arrays;

public class Debugger {
    public Class<?> DebugObject;

    public Debugger(Object DebugObject) {
        this.DebugObject = DebugObject.getClass();
    }

    public void printData() throws AnnotationException {
        if (DebugObject.getAnnotation(DisplayDebugData.class) != null){
            String[] messages = new String[]{
                    "Class Name: "+this.DebugObject.getName(),
                    "Inherited Classes: "+this.DebugObject.getSuperclass().getName(),
                    //"Package: "+this.DebugObject.getPackage().getName(),
                    "The com.hxgfk.interfaces implemented: "+ Arrays.toString(this.DebugObject.getInterfaces()),
                    "Annotations: "+ Arrays.toString(this.DebugObject.getAnnotations()),
                    "Methods: "+ Arrays.toString(this.DebugObject.getDeclaredMethods()),
                    "Constructor: "+ Arrays.toString(this.DebugObject.getConstructors()),
                    "Fields: "+ Arrays.toString(this.DebugObject.getDeclaredFields()),
                    "Class Loader: "+this.DebugObject.getClassLoader().toString()
            };
            for (String string : messages){
                System.out.println(string);
            }
        }else {
            throw new AnnotationException("No annotations found for DisplayDebugData");
        }
    }
}
