package com.fingerboarddiagram;

public class Main {
    public static void main(String[] args) throws Exception {
        Diagram diagram = new Diagram(260 * 2, 210 * 2);
        FingerBoard fingerBoard = new FingerBoard(diagram, 1, 3, 1, 6);
        fingerBoard.addFinger(5, 2);
        fingerBoard.addFinger(3, 2);
        fingerBoard.addFinger(4, 3);
        fingerBoard.addFinger(1, 3);

        Svg svg = new Svg(diagram.getWidth(), diagram.getHeight());

        diagram.draw(svg.graphics);
        fingerBoard.draw(svg.graphics);

        svg.save("svg.svg");
        System.out.println("Hello world!");
    }

}