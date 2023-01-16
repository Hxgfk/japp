package com.hxgfk.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class document {
    public final Document document;

    public document(URL path) throws DocumentException {
        this.document = (new SAXReader()).read(path);
    }

    public document(String filename) throws DocumentException {
        this.document = (new SAXReader()).read(new File(filename));
    }

    public document(File file) throws DocumentException {
        this.document = (new SAXReader()).read(file);
    }

    public Document getDocument(){
        return this.document;
    }

    public Element getRootElement(){
        return this.document.getRootElement();
    }

    public Element getElementById(String ElementId){
        return this.document.elementByID(ElementId);
    }

    public List<Element> getElementsByName(String name){
        List<Element> elements = new ArrayList<>();
        for (Element e : this.getRootElement().elements()){
            if (e.attribute("name").getValue().equals(name)){
                elements.add(e);
            }
        }
        return elements;
    }

    public List<Element> getElemenetsByTagName(String ElementName){
        List<Element> elements = new ArrayList<>();
        for (Element e : this.getRootElement().elements()){
            if (e.getName().equals(ElementName)){
                elements.add(e);
            }
        }
        return elements;
    }

    public void remove(Element element){
        this.document.remove(element);
    }
}
