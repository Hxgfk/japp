package com.hxgfk.hash;

public class HashEntry <T>{
    private final String key;
    private T value;
    public HashEntry<T> pointer;

    public HashEntry(String key, T value) {
        this.key = key;
        this.value = value;
        assert key == null;
    }

    public T getValue(){
        return this.value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public String getKey(){
        return this.key;
    }
}
