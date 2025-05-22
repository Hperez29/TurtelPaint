package com.pluralsight;

import java.awt.Color;
import java.awt.Point;

public class Circle extends Shape {
    private int radius;

    public Circle(Turtle turtle, Point location, Color color, int borderWidth, int radius) {
        super(turtle, location, color, borderWidth);
        this.radius = radius;
    }

    @Override
    public void paint() {
        turtle.setColor(color);
        turtle.setPenWidth(borderWidth);
        turtle.penUp();
        turtle.goTo(location.x + radius, location.y);  // start at edge of circle
        turtle.penDown();

        for (int i = 0; i < 360; i++) {
            turtle.forward((2 * Math.PI * radius) / 360);  // approximate arc length
            turtle.turnRight(1);
        }
    }
}
