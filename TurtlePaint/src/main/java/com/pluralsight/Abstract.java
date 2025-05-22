package com.pluralsight;

public abstract class Shape {
    protected Turtle turtle;
    protected Point location;
    protected String color;
    protected int border;

    public Shape(Turtle turtle, Point location, String color, int border) {
        this.turtle = turtle;
        this.location = location;
        this.color = color;
        this.border = border;
    }

    public abstract void paint();
}