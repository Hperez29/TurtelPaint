package com.pluralsight;

import java.awt.Point;
import java.awt.Color;

public class Square extends Shape {
    private int sideLength;

    public Square(Turtle turtle, Point location, Color color, int borderWidth, int sideLength) {
        super(turtle, location, color, borderWidth);
        this.sideLength = sideLength;
    }

    public void paint() {
        turtle.setColor(color);
        turtle.setPenWidth(borderWidth);
        turtle.penUp();
        turtle.goTo(location.x, location.y);
        turtle.penDown();

        for (int i = 0; i < 4; i++) {
            turtle.forward(sideLength);
            turtle.turnRight(90);
        }
    }
}