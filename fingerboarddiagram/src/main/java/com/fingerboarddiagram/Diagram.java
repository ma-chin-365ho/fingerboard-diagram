package com.fingerboarddiagram;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class Diagram {

    private final int width;
    private final int height;

    public Diagram(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics2D graphics) {
        graphics.setPaint(Color.WHITE);
        graphics.fill(new Rectangle2D.Double(0, 0, this.getWidth(), this.getHeight()));
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
