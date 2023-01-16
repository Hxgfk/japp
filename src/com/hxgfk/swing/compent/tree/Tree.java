package com.hxgfk.swing.compent.tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class Tree extends JTree {

    private DefaultMutableTreeNode root;

    public Tree(String rootNodeName) {
        this.root = new DefaultMutableTreeNode(rootNodeName, true);
    }

    public DefaultMutableTreeNode getRoot() {
        return this.root;
    }

    private DefaultMutableTreeNode constructor(Object val){
        return new DefaultMutableTreeNode(val);
    }

    public void addNode(DefaultMutableTreeNode node){
        this.root.add(node);
    }

    public void removeAll(){
        this.root.removeAllChildren();
    }

    public void setRoot(DefaultMutableTreeNode root){
        this.root = root;
    }

    public void addDataToSuper(Object data){
        this.root.add(this.constructor(data));
    }
}
