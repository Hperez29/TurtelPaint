package com.pluralsight;

import java.awt.Point;
import java.util.*;
import TurtleGraphics.*;

public class TurtlePaintApp {
    private Scanner scanner = new Scanner(System.in);
    private List<Shape> shapes = new ArrayList<>();
    private World world;

    public static void main(String[] args) {
        new TurtlePaintApp().start();
    }

    public void start() {
        System.out.print("Enter canvas width: ");
        int width = scanner.nextInt();
        System.out.print("Enter canvas height: ");
        int height = scanner.nextInt();
        world = new World(width, height);

        while (true) {
            System.out.println("\n1) Add Shape\n2) Save Image\n0) Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addShape();
                case 2 -> world.show(true); // Show canvas
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void addShape() {
        System.out.println("Which shape? (1) Square (2) Circle (3) Triangle");
        int shapeChoice = scanner.nextInt();

        System.out.print("Enter border width: ");
        int border = scanner.nextInt();
        System.out.print("Enter border color (e.g., #FF0000): ");
        String color = scanner.next();
        System.out.print("Enter X location: ");
        int x = scanner.nextInt();
        System.out.print("Enter Y location: ");
        int y = scanner.nextInt();
        Point location = new Point(x, y);
        Turtle turtle = new StandardTurtle(world);

        Shape shape = null;
        switch (shapeChoice) {
            case 1 -> {
                System.out.print("Enter side length: ");
                int length = scanner.nextInt();
                shape = new Square(turtle, location, color, border, length);
            }
            case 2 -> {
                System.out.print("Enter radius: ");
                int radius = scanner.nextInt();
                shape = new Circle(turtle, location, color, border, radius);
            }
            case 3 -> {
                System.out.print("Enter base length: ");
                int base = scanner.nextInt();
                shape = new Triangle(turtle, location, color, border, base);
            }
            default -> System.out.println("Unknown shape.");
        }

        if (shape != null) {
            shapes.add(shape);
            shape.paint();
        }
    }
}
