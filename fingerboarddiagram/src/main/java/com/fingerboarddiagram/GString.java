package com.fingerboarddiagram;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.BasicStroke;
import java.awt.Color;

public class GString {

    private final FingerBoard fingerBoard;
    private final int stringNumber;
    private final double positionOffsetY;

    public GString(FingerBoard fingerBoard, int stringNumber) {
        this.fingerBoard = fingerBoard;
        this.stringNumber = stringNumber;
        this.positionOffsetY = (this.stringNumber - 1) * this.fingerBoard.getHeight()
                / (this.fingerBoard.getStringCount() - 1);
    }

    public void draw(Graphics2D graphics) {
        graphics.setStroke(
                new BasicStroke((float) (this.fingerBoard.getWidth() + this.fingerBoard.getHeight()) / 80.0f));
        graphics.setPaint(Color.BLACK);

        Line2D line = new Line2D.Double(this.getPositionStartX(), this.getPositionStartY(), this.getPositionEndX(),
                this.getPositionEndY());
        graphics.draw(line);
    }

    public double getPositionStartX() {
        return this.fingerBoard.getPositionStartX();
    }

    public double getPositionStartY() {
        return this.fingerBoard.getPositionStartY() + this.positionOffsetY;
    }

    public double getPositionEndX() {
        return this.fingerBoard.getPositionEndX();
    }

    public double getPositionEndY() {
        return this.fingerBoard.getPositionStartY() + this.positionOffsetY;
    }

    public int getStringNumber() {
        return this.stringNumber;
    }

}
