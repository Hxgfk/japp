package com.hxgfk.swing.alerts;

import javax.swing.*;

public class Info{
    public Info(String title, String say){
        JOptionPane.showMessageDialog(null, say, title, JOptionPane.PLAIN_MESSAGE);
    }
}
