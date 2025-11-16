package com.fingerboarddiagram;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class FingerBoard {

    private final Diagram diagram;
    private final int fretNumberStart;
    private final int fretNumberEnd;
    private final int stringNumberStart;
    private final int stringNumberEnd;
    private final GFret[] frets;
    private final GString[] strings;
    private final ArrayList<GFinger> fingers;

    public FingerBoard(Diagram diagram, int fretNumberStart, int fretNumberEnd, int stringNumberStart,
            int stringNumberEnd) {
        this.diagram = diagram;
        this.fretNumberStart = fretNumberStart;
        this.fretNumberEnd = fretNumberEnd;
        this.stringNumberStart = stringNumberStart;
        this.stringNumberEnd = stringNumberEnd;
        this.frets = new GFret[this.getFretCount()];
        for (int i = 0; i < this.getFretCount(); i++) {
            this.frets[i] = new GFret(this, this.fretNumberStart + i);
        }
        this.strings = new GString[this.getStringCount()];
        for (int i = 0; i < this.getStringCount(); i++) {
            this.strings[i] = new GString(this, this.stringNumberStart + i);
        }
        this.fingers = new ArrayList<GFinger>();
    }

    public void addFinger(int stringNumber, int fretNumber) {

        GFinger gFinger = new GFinger(this, this.getGString(stringNumber), this.getGFret(fretNumber));
        this.fingers.add(gFinger);
    }

    public void draw(Graphics2D graphics) {
        for (GFret fret : this.frets) {
            fret.draw(graphics);
        }
        for (GString string : this.strings) {
            string.draw(graphics);
        }
        for (GFinger finger : this.fingers) {
            finger.draw(graphics);
        }
    }

    public double getPositionStartX() {
        return this.diagram.getWidth() / 8.0;
    }

    public double getPositionStartY() {
        return this.diagram.getHeight() / 7.0;
    }

    public double getPositionEndX() {
        return this.diagram.getWidth() - (this.diagram.getWidth() / 8.0);
    }

    public double getPositionEndY() {
        return this.diagram.getHeight() - (this.diagram.getHeight() / 7.0);
    }

    public double getWidth() {
        return this.getPositionEndX() - this.getPositionStartX();
    }

    public double getHeight() {
        return this.getPositionEndY() - this.getPositionStartY();
    }

    public int getFretNumberStart() {
        return this.fretNumberStart;
    }

    public int getFretNumberEnd() {
        return this.fretNumberEnd;
    }

    public int getFretCount() {
        return this.fretNumberEnd - this.fretNumberStart + 1;
    }

    public int getStringNumberStart() {
        return this.stringNumberStart;
    }

    public int getStringNumberEnd() {
        return this.stringNumberEnd;
    }

    public int getStringCount() {
        return this.stringNumberEnd - this.stringNumberStart + 1;
    }

    public GString getGString(int stringNumber) {
        for (int i = 0; i < this.getStringCount(); i++) {
            if (this.strings[i].getStringNumber() == stringNumber) {
                return this.strings[i];
            }
        }
        return null;
    }

    public GFret getGFret(int fretNumber) {
        for (int i = 0; i < this.getFretCount(); i++) {
            if (this.frets[i].getFretNumber() == fretNumber) {
                return this.frets[i];
            }
        }
        return null;
    }

    public double getLengthBetweenFrets() {
        return this.getWidth() / (this.getFretCount() - 1);
    }

    public double getLengthBetweenStrings() {
        return this.getHeight() / (this.getStringCount() - 1);
    }
}