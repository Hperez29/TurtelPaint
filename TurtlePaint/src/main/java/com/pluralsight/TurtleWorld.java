package com.pluralsight;

import java.awt.*;
import java.util.*;

public final class MainApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final java.util.List<Shape> shapes = new ArrayList<>();

    public static void main(String[] args) {
        System.out.print("Enter canvas width: ");
        int width = scanner.nextInt();
        System.out.print("Enter canvas height: ");
        int height = scanner.nextInt();

        World world = new World(width, height);
        Turtle turtle = new Turtle(world);

        while (true) {
            System.out.println("\n1) Add Shape\n2) Show Image\n0) Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addShape(turtle);
                case 2 -> {
                    for (Shape shape : shapes) shape.paint();
                }
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void addShape(Turtle turtle) {
        System.out.println("Choose shape: 1) Square");
        int shapeChoice = scanner.nextInt();

        System.out.print("Border width: ");
        int borderWidth = scanner.nextInt();
        System.out.print("Color (R G B): ");
        int r = scanner.nextInt(), g = scanner.nextInt(), b = scanner.nextInt();
        Color color = new Color(r, g, b);
        System.out.print("X position: ");
        int x = scanner.nextInt();
        System.out.print("Y position: ");
        int y = scanner.nextInt();
        Point location = new Point(x, y);

        Shape shape = null;

        if (shapeChoice == 1) {
            System.out.print("Side length: ");
            int length = scanner.nextInt();
            shape = new Square(turtle, location, color, borderWidth, length);
        }

        if (shape != null) {
            shapes.add(shape);
            shape.paint();
        }
    }
}