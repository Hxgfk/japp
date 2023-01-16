package com.hxgfk.hash;

import com.hxgfk.util.Array;

public class HashMap <ValueType>{
    private int size;
    private final HashEntry<ValueType>[] data = (HashEntry<ValueType>[]) new HashEntry[this.size];

    public HashMap(int size){
        this.size = size;
    }

    public HashEntry<?> get(String key){
        int hash = key.hashCode() % this.size;
        HashEntry<ValueType> entry = this.data[hash];
        HashEntry<ValueType> d = null;
        while (entry != null){
            if (entry.getKey().equals(key)){
                d = entry;
            }
            entry = entry.pointer;
        }
        return d;
    }

    public void add(String key, ValueType value){
        int hash = key.hashCode() % this.size;
        HashEntry<ValueType> entry = this.data[hash];
        if (entry != null){
            while (entry.pointer != null){
                if (entry.getKey().equals(key)){
                    entry.setValue(value);
                }
                entry = entry.pointer;
            }
            entry.pointer = new HashEntry<>(key, value);
        }else {
            this.data[hash] = new HashEntry<>(key, value);
        }
    }

    public int getLength(){
        return this.size;
    }

    @Deprecated
    public ValueType[] getAllValue(){
        ValueType[] arr = (ValueType[]) new Object[]{};
        for (HashEntry<ValueType> entry : this.data){
            Array.add(entry.getValue(), arr);
        }
        return arr;
    }

    @Deprecated
    public String[] getAllKey(){
        String[] arr = new String[]{};
        for (HashEntry<ValueType> entry : this.data){
            Array.add(entry.getKey(), arr);
        }
        return arr;
    }
}
