package com.hxgfk.json;

import com.alibaba.fastjson2.JSONObject;

public class JSONData extends JSONObject {
    public JSONData(){
        super();
    }

    public void add(String key, String value){
        put(key, value);
    }

    public void add(String key, boolean value){
        put(key, value);
    }

    public void add(String key, int value){
        put(key, value);
    }

    public void add(String key, boolean[] value){
        put(key, value);
    }

    public void add(String key, int[] value){
        put(key, value);
    }

    public void add(String key, String[] value){
        put(key, value);
    }

    public Object getValue(String key){
        return get(key);
    }

    public void remove(String key){
        remove(key);
    }
}
