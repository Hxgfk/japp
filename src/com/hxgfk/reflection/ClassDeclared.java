package com.hxgfk.reflection;

import com.hxgfk.cp.ClassProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassDeclared<T> extends ReflectionClass<T> {
    public static class Declared{
        private final ClassProperty classProperty = new ClassProperty();

        public Declared(Method[] methods, Field[] fields, Constructor<?>[] constructors, Annotation[] annotations, Class<?>[] classes){
            this.classProperty.add("methods", methods);
            this.classProperty.add("fields", fields);
            this.classProperty.add("classes", classes);
            this.classProperty.add("constructors", constructors);
            this.classProperty.add("annotations", annotations);
        }

        public Method[] methods(){
            return (Method[]) this.classProperty.get("methods").getValue();
        }

        public Field[] fields(){
            return (Field[]) this.classProperty.get("fields").getValue();
        }

        public Class<?>[] classes(){
            return (Class<?>[]) this.classProperty.get("classes").getValue();
        }

        public Constructor<?>[] constructors(){
            return (Constructor<?>[]) this.classProperty.get("constructors").getValue();
        }

        public Annotation[] annotations(){
            return (Annotation[]) this.classProperty.get("annotations").getValue();
        }
    }

    public ClassDeclared(Class<T> tClass){
        super(tClass);
    }

    public Method[] declaredMethods(){
        return super.classes().getDeclaredMethods();
    }

    public Method declaredMethod(String name) throws NoSuchMethodException {
        return super.classes().getDeclaredMethod(name);
    }

    public Field[] declaredFields(){
        return super.classes().getDeclaredFields();
    }

    public Field declaredField(String name) throws NoSuchFieldException {
        return super.classes().getDeclaredField(name);
    }

    public Class<?>[] declaredClasses(){
        return super.classes().getDeclaredClasses();
    }

    public Constructor<?>[] declaredConstructors(){
        return super.classes().getDeclaredConstructors();
    }

    public Constructor<?> declaredConstructor() throws NoSuchMethodException {
        return super.classes().getDeclaredConstructor();
    }

    public Annotation[] declaredAnnotations(){
        return super.classes().getDeclaredAnnotations();
    }

    public Annotation declaredAnnotation(Class<? extends Annotation> annotation){
        return super.classes().getDeclaredAnnotation(annotation);
    }

    public Annotation[] declaredAnnotations(Class<? extends Annotation> annotationType){
        return super.classes().getDeclaredAnnotationsByType(annotationType);
    }

    public Declared declared(){
        return new Declared(this.declaredMethods(), this.declaredFields(), this.declaredConstructors(), this.declaredAnnotations(), this.declaredClasses());
    }
}
