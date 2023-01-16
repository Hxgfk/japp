package com.hxgfk.util;

public class Array {
    public static Object[] add(Object element, Object[] array) {
        if (array.length == 0){
            return new Object[]{element};
        }else {
            Object[] arr = new Object[array.length+1];
            System.arraycopy(array, 0, arr, 0, array.length);
            arr[array.length] = element;
            return arr;
        }
    }

    public static Object[] delete(int index, Object[] array) throws Exception {
        if (array.length != 0){
            Object[] arr = new Object[array.length-1];
            for(int i=0;i<arr.length;i++) {
                if(i < index){
                    arr[i] = array[i];
                }else {
                    arr[i] = array[i+1];
                }
            }
            return arr;
        }else {
            throw new Exception("");
        }
    }
}
