package com.hxgfk.swing.panels;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WaveformDrawPanel extends JPanel {
    private final List<Integer> value = Collections.synchronizedList(new ArrayList<>());
    private int DrawMaxValue = 0x7fffffff;
    private Color color = Color.BLACK;
    private int MAX_COUNT_OF_VALUES = 100;
    private final int UpdateTime;
    private Thread DrawerThread;

    public void startDraw(){
        Runnable DrawerThreadRun = () -> {
            try {
                while (true){
                    repaint();
                    Thread.sleep(UpdateTime);
                }
            }catch (InterruptedException exception){
                exception.printStackTrace();
            }
        };
        this.DrawerThread = new Thread(DrawerThreadRun);
        this.DrawerThread.start();
    }

    public WaveformDrawPanel(int UpdateTime, int DrawMaxValue, Color color, int MaxCountOfValue){
        this.DrawMaxValue = DrawMaxValue;
        this.color = color;
        this.MAX_COUNT_OF_VALUES = MaxCountOfValue;
        this.UpdateTime = UpdateTime;
    }

    public WaveformDrawPanel(int UpdateTime){
        this.UpdateTime = UpdateTime;
    }

    private int normalizeValueForYAxis(int value, int height){
        return (int) ((double) height/this.DrawMaxValue*value);
    }

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(this.color);
        int w = getWidth();
        int h = getHeight();
        int xDelta = w / MAX_COUNT_OF_VALUES;
        int length = value.size();

        for (int i = 0; i < length - 1; ++i) {
            g2d.drawLine(xDelta * (MAX_COUNT_OF_VALUES - length + i),h-this.normalizeValueForYAxis(value.get(i), h),
                    xDelta * (MAX_COUNT_OF_VALUES - length + i + 1),h-this.normalizeValueForYAxis(value.get(i + 1), h));
        }
    }

    public void draw(int value){
        if (this.value.size() > this.MAX_COUNT_OF_VALUES){
            this.value.remove(0);
        }
        this.value.add(value);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(UpdateTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        }).start();
    }
}
