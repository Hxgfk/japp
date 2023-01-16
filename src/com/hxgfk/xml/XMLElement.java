package com.hxgfk.xml;

import org.dom4j.Attribute;
import org.dom4j.Element;

import java.util.List;

public class XMLElement {
    private final Element element;

    public XMLElement(Element element){
        this.element = element;
    }

    public void setAttribute(String key, String value){
        this.element.addAttribute(key, value);
    }

    public Object getAttributeValue(String key){
        return this.element.attribute(key).getValue();
    }

    public Attribute getAttribute(String key){
        return this.element.attribute(key);
    }

    public void setAttributeTable(List<Attribute> table){
        this.element.setAttributes(table);
    }

    public String getValue(){
        return this.element.getText();
    }

    public Element getElement(){
        return this.element;
    }

    public void setValue(String value){
        this.element.setText(value);
    }
}
