package com.pluralsight;

import java.awt.Point;

public class Square extends Shape {
    private int sideLength;

    public Square(Turtle turtle, Point location, String color, int border, int sideLength) {
        super(turtle, location, color, border);
        this.sideLength = sideLength;
    }

    @Override
    public void paint() {
        turtle.penUp();
        turtle.moveTo(location.x, location.y);
        turtle.setColor(java.awt.Color.decode(color));
        turtle.penDown();
        turtle.width(border);
        for (int i = 0; i < 4; i++) {
            turtle.forward(sideLength);
            turtle.turnRight(90);
        }
    }
}

public class Circle extends Shape {
    private int radius;

    public Circle(Turtle turtle, Point location, String color, int border, int radius) {
        super(turtle, location, color, border);
        this.radius = radius;
    }

    @Override
    public void paint() {
        turtle.penUp();
        turtle.moveTo(location.x, location.y - radius); // Start at top of circle
        turtle.setColor(java.awt.Color.decode(color));
        turtle.penDown();
        turtle.width(border);
        turtle.drawCircle(radius);
    }
}

public class Triangle extends Shape {
    private int base;

    public Triangle(Turtle turtle, Point location, String color, int border, int base) {
        super(turtle, location, color, border);
        this.base = base;
    }

    @Override
    public void paint() {
        turtle.penUp();
        turtle.moveTo(location.x, location.y);
        turtle.setColor(java.awt.Color.decode(color));
        turtle.penDown();
        turtle.width(border);

        turtle.forward(base);
        turtle.turnRight(120);
        turtle.forward(base);
        turtle.turnRight(120);
        turtle.forward(base);
        turtle.turnRight(120);
    }
}
