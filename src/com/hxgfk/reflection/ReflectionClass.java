package com.hxgfk.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionClass<T>{
    protected Class<T> tClass;

    public ReflectionClass(Class<T> tClass){
        this.tClass = tClass;
    }

    public String name(){
        return this.tClass.getName();
    }

    public Class<?> superClass(){
        return this.tClass.getSuperclass();
    }

    public Package packageName(){
        return this.tClass.getPackage();
    }

    public Class<?>[] implementedInterface(){
        return this.tClass.getInterfaces();
    }

    public Annotation[] annotations(){
        return this.tClass.getAnnotations();
    }

    public Annotation[] annotationsByType(Class<? extends Annotation> type){
        return this.tClass.getAnnotationsByType(type);
    }

    public Method[] methods(){
        return this.tClass.getMethods();
    }

    public Method getMethod(String methodName) throws NoSuchMethodException {
        return this.tClass.getMethod(methodName);
    }

    public Constructor<?>[] constructor(){
        return this.tClass.getConstructors();
    }

    public Constructor<?> constructor(Class<?>... c) throws NoSuchMethodException {
        return this.tClass.getConstructor(c);
    }

    public Field[] field(){
        return this.tClass.getFields();
    }

    public Field field(String name) throws NoSuchFieldException {
        return this.tClass.getField(name);
    }

    public ClassLoader classLoader(){
        return this.tClass.getClassLoader();
    }

    public Class<T> classes(){
        return this.tClass;
    }
}
