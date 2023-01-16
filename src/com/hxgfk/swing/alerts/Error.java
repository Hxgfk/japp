package com.hxgfk.swing.alerts;

import javax.swing.*;

public class Error{
    public Error(String title, String say){
        JOptionPane.showMessageDialog(null, say, title, JOptionPane.ERROR_MESSAGE);
    }
}
