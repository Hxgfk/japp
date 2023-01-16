package com.hxgfk.cp;


public class ClassProperty{
    private Property[] properties = new Property[]{};

    /**
     * Remove Property by name
     */
    public void remove(String name){
        for (int i=0;i<this.properties.length;i++){
            if (this.properties[i].getName().equals(name)){
                Property[] temp = new Property[this.properties.length-1];
                for(int k=0;k<temp.length;k++)
                {
                    if(k < i){
                        temp[k] = this.properties[k];
                    } else{
                        temp[k] = this.properties[k+1];
                    }
                }
                this.properties=temp;
            }
        }
    }

    /**
     * Add property
     */
    public void add(String name, Object value){
        Property[] array = new Property[this.properties.length+1];
        System.arraycopy(this.properties, 0, array, 0, this.properties.length);
        array[this.properties.length] = new Property(name, value);
        this.properties = array;
    }

    /**
     * Add property
     */
    public void add(String name, Object[] value){
        Property[] array = new Property[this.properties.length+1];
        System.arraycopy(this.properties, 0, array, 0, this.properties.length);
        array[this.properties.length] = new Property(name, value);
        this.properties = array;
    }

    /**
     * Add property
     */
    public void add(Property property){
        Property[] array = new Property[this.properties.length+1];
        System.arraycopy(this.properties, 0, array, 0, this.properties.length);
        array[this.properties.length] = property;
        this.properties = array;
    }

    /**
     * Set Property by name
     */
    public void set(String name, Object value){
        for (Property property : this.properties) {
            if (property.getName().equals(name)) {
                property.setValue(value);
            }
        }
    }

    /**
     * Set Property by name
     */
    public void set(String name, Object[] value){
        for (Property property : this.properties) {
            if (property.getName().equals(name)) {
                property.setValue(value);
            }
        }
    }

    /**
     * Get property by name
     */
    public Property get(String name){
        Property property = null;
        for (Property p : this.properties) {
            if (p.getName().equals(name)){
                property = p;
                break;
            }
        }
        return property;
    }

    /**
     * Get all property
     * @return Property[]
     */
    public Property[] getAllProperty(){
        return this.properties;
    }
}
