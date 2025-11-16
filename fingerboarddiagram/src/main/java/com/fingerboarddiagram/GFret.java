package com.fingerboarddiagram;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.BasicStroke;
import java.awt.Color;

public class GFret {

    private final FingerBoard fingerBoard;
    private final int fretNumber;
    private final double positionOffsetX;

    public GFret(FingerBoard fingerBoard, int fretNumber) {
        this.fingerBoard = fingerBoard;
        this.fretNumber = fretNumber;
        this.positionOffsetX = (this.fretNumber - this.fingerBoard.getFretNumberStart()) * this.fingerBoard.getWidth()
                / (this.fingerBoard.getFretCount() - 1);
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
        return this.fingerBoard.getPositionStartX() + this.positionOffsetX;
    }

    public double getPositionStartY() {
        return this.fingerBoard.getPositionStartY();
    }

    public double getPositionEndX() {
        return this.fingerBoard.getPositionStartX() + this.positionOffsetX;
    }

    public double getPositionEndY() {
        return this.fingerBoard.getPositionEndY();
    }

    public int getFretNumber() {
        return this.fretNumber;
    }

}
