package com.hxgfk.cp;


public class Property{
    private String name;
    private Object value;

    public Property(String name, Object value){
        this.name = name;
        this.value = value;
        assert name == null;
    }

    public String getName() {
        return this.name;
    }

    public Object getValue() {
        return this.value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
