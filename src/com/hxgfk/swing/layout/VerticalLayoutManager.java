package com.hxgfk.swing.layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;

// 垂直布局管理器
public class VerticalLayoutManager extends FlowLayout {
    private static final long serialVersionUID = 1L;
    public static final int TOP = 0;
    public static final int MIDDLE = 1;
    public static final int BOTTOM = 2;
    private final int hgap;
    private final int vgap;
    private boolean hfill;
    private boolean vfill;

    public VerticalLayoutManager() {
        this(TOP, 5, 5, true, false);
    }


    public VerticalLayoutManager(boolean hfill, boolean vfill) {
        this(TOP, 5, 5, hfill, vfill);
    }


    public VerticalLayoutManager(int align) {
        this(align, 5, 5, true, false);
    }


    public VerticalLayoutManager(int align, boolean hfill, boolean vfill) {
        this(align, 5, 5, hfill, vfill);
    }


    public VerticalLayoutManager(int align, int hgap, int vgap, boolean hfill, boolean vfill) {
        super.setAlignment(align);
        this.hgap = hgap;
        this.vgap = vgap;
        this.hfill = hfill;
        this.vfill = vfill;
    }


    public Dimension preferredLayoutSize(Container target) {
        Dimension dimension = new Dimension(0, 0);
        for (int i = 0; i < target.getComponentCount(); i++)
        {
            Component component = target.getComponent(i);
            if (component.isVisible()) {
                Dimension d = component.getPreferredSize();
                dimension.width = Math.max(dimension.width, d.width);
                if (i > 0) {
                    dimension.height += hgap;
                }
                dimension.height += d.height;
            }
        }
        Insets insets = target.getInsets();
        dimension.width += insets.left + insets.right + hgap * 2;
        dimension.height += insets.top + insets.bottom + vgap * 2;
        return dimension;
    }


    public Dimension minimumLayoutSize(Container target) {
        Dimension dimension = new Dimension(0, 0);
        for (int i = 0; i < target.getComponentCount(); i++)
        {
            Component component = target.getComponent(i);
            if (component.isVisible()) {
                Dimension d = component.getMinimumSize();
                dimension.width = Math.max(dimension.width, d.width);
                if (i > 0) {
                    dimension.height += vgap;
                }
                dimension.height += d.height;
            }
        }
        Insets insets = target.getInsets();
        dimension.width += insets.left + insets.right + hgap * 2;
        dimension.height += insets.top + insets.bottom + vgap * 2;
        return dimension;
    }


    public void setVerticalFill(boolean vfill) {
        this.vfill = vfill;
    }


    public boolean getVerticalFill() {
        return vfill;
    }


    public void setHorizontalFill(boolean hfill) {
        this.hfill = hfill;
    }


    public boolean getHorizontalFill() {
        return hfill;
    }


    private void placethem(Container target, int x, int y, int width, int height, int first, int last)
    {
        int align = getAlignment();
        if (align == MIDDLE) {
            y += height / 2;
        }
        if (align == BOTTOM) {
            y += height;
        }
        for (int i = first; i < last; i++)
        {
            Component component = target.getComponent(i);
            Dimension size = component.getSize();

            if (component.isVisible())
            {
                int px = x + (width - size.width) / 2;
                component.setLocation(px, y);
                y += vgap + size.height;
            }
        }
    }


    public void layoutContainer(Container target)
    {
        Insets insets = target.getInsets();
        int maxheight = target.getSize().height - (insets.top + insets.bottom + vgap * 2);
        int maxwidth = target.getSize().width - (insets.left + insets.right + hgap * 2);
        int componentCount = target.getComponentCount();
        int x = insets.left + hgap, y = 0;
        int colw = 0, start = 0;
        for (int i = 0; i < componentCount; i++)
        {
            Component component = target.getComponent(i);
            if (component.isVisible())
            {
                Dimension dimension = component.getPreferredSize();
                // fit last component to remaining height
                if ((this.vfill) && (i == (componentCount - 1))) {
                    dimension.height = Math.max((maxheight - y), component.getPreferredSize().height);
                }
                // fit component size to container width
                if (this.hfill) {
                    component.setSize(maxwidth, dimension.height);
                    dimension.width = maxwidth;
                } else {
                    component.setSize(dimension.width, dimension.height);
                }
                if (y + dimension.height > maxheight) {
                    placethem(target, x, insets.top + vgap, colw, maxheight - y, start, i);
                    y = dimension.height;
                    x += hgap + colw;
                    colw = dimension.width;
                    start = i;
                } else {
                    if (y > 0) {
                        y += vgap;
                    }
                    y += dimension.height;
                    colw = Math.max(colw, dimension.width);
                }
            }
        }
        placethem(target, x, insets.top + vgap, colw, maxheight - y, start, componentCount);
    }
}