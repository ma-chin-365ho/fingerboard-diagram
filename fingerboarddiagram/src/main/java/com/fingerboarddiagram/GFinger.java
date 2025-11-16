package com.fingerboarddiagram;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.BasicStroke;
import java.awt.Color;

public class GFinger {

    private final FingerBoard fingerBoard;
    private final GString gString;
    private final GFret gFret;

    public GFinger(FingerBoard fingerBoard, GString gString, GFret gFret) {
        this.fingerBoard = fingerBoard;
        this.gString = gString;
        this.gFret = gFret;
    }

    public void draw(Graphics2D graphics) {
        graphics.setStroke(
                new BasicStroke((float) (this.fingerBoard.getWidth() + this.fingerBoard.getHeight()) / 80.0f));
        graphics.setPaint(Color.BLACK);

        graphics.fill(new Ellipse2D.Double(this.getPositionStartX(), this.getPositionStartY(), this.getWidth(),
                this.getHeight()));
    }

    public double getPositionStartX() {
        return this.gFret.getPositionStartX() - (this.fingerBoard.getLengthBetweenFrets() / 2.0) - this.getRadius();
    }

    public double getPositionStartY() {
        return this.gString.getPositionStartY() - this.getRadius();
    }

    public double getWidth() {
        return this.getRadius() * 2.0;
    }

    public double getHeight() {
        return this.getRadius() * 2.0;
    }

    public double getRadius() {
        return this.fingerBoard.getLengthBetweenStrings() / 1.9;
    }
}
