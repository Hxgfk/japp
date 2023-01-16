package com.hxgfk.swing.alerts;

import javax.swing.*;

public class Info2 extends JFrame {
    public final JPanel panel = new JPanel();
    public Info2(int x, int y, int width, int height, String title, String say){
        setTitle(title);
        setBounds(x, y, width, height);
        panel.add(new JLabel(say));
        setContentPane(panel);
        setVisible(true);
        requestFocusInWindow();
        setResizable(false);
    }
}
