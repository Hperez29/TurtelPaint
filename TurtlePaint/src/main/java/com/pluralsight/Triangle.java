package com.pluralsight;

import java.awt.Color;
import java.awt.Point;

public class Triangle extends Shape {
    private int sideLength;

    public Triangle(Turtle turtle, Point location, Color color, int borderWidth, int sideLength) {
        super(turtle, location, color, borderWidth);
        this.sideLength = sideLength;
    }

    @Override
    public void paint() {
        turtle.setColor(color);
        turtle.setPenWidth(borderWidth);
        turtle.penUp();
        turtle.goTo(location.x, location.y);
        turtle.penDown();

        for (int i = 0; i < 3; i++) {
            turtle.forward(sideLength);
            turtle.turnRight(120); // Each angle in equilateral triangle is 60°
        }
    }
}