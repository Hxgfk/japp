package com.hxgfk.swing.panels;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class ConsolePanel extends JPanel {
    private JTextArea consolearea = new JTextArea();
    private JScrollPane scrollPane;
    private boolean hasScrollbar;

    public ConsolePanel(boolean scrollbar){
        this.setHasScrollbar(scrollbar);
    }

    public ConsolePanel(boolean scrollbar, Color background, Color textcolor){
        this.setHasScrollbar(scrollbar);
        this.setBackground(background);
        this.setTextColor(textcolor);
    }

    public ConsolePanel(boolean scrollbar, Dimension dimension, Color background, Color textcolor){
        this.setHasScrollbar(scrollbar);
        this.setSize(dimension);
        this.setBackground(background);
        this.setTextColor(textcolor);
    }

    private void setHasScrollbar(boolean scrollbar){
        if (scrollbar){
            this.scrollPane = new JScrollPane(this.consolearea);
            super.add(this.scrollPane);
        }else {
            super.add(this.consolearea);
        }
    }

    public void setTextColor(Color color){
        super.setForeground(color);
    }

    public void setEditable(boolean editable){
        this.consolearea.setEditable(editable);
    }

    public void setText(String text){
        this.consolearea.setText(text);
    }

    @Override
    public void setBackground(Color bg) {
        this.consolearea.setBackground(bg);
    }

    @Override
    public void setForeground(Color fg) {
        this.consolearea.setForeground(fg);
    }

    public JScrollPane getScrollPane() {
        return this.scrollPane;
    }

    public JTextArea getTextArea() {
        return this.consolearea;
    }

    public PrintStream stream = new PrintStream(new OutputStream() {
        @Override
        public void write(int b) throws IOException {
            consolearea.append(String.valueOf((char) b));
        }
    });

    public PrintStream getStream() {
        return this.stream;
    }

    public void setSystemOutToThis(){
        System.setOut(stream);
        System.setErr(stream);
    }

    public void print(Object s){
        this.consolearea.append(s.toString());
    }

    public void println(Object s){
        this.consolearea.append(s.toString()+"\n");
    }
}
