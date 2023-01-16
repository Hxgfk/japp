package com.hxgfk.reflection;


import java.lang.annotation.Annotation;

public class ReflectionAnnotation {
    /**
     * Gets the specified annotation for the specified class
     * @return Annotation
     */
    public Annotation getAnnotation(Class<?> parent, Class<? extends Annotation> annotation){
        return parent.getAnnotation(annotation);
    }

    /**Gets the same specified annotation for the specified class, note that the specified annotation needs to contain Repeatable
     * @return Annotation[]
     */
    public Annotation[] getTheSameAnnotations(Class<?> parent, Class<? extends Annotation> annotation) throws Exception{
        //if (parent.getAnnotation(annotation) == null){
        //    throw new AnnotationException("Class '"+parent.getName()+"' no annotation '"+annotation.getName()+"'");
        //}else {
        //    return parent.getAnnotationsByType(annotation);
        //}
        return parent.getAnnotationsByType(annotation);
    }
}
