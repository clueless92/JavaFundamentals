package Softuniada2016;

import java.util.Scanner;

public class Pr05CrossingFigures {
    static Rectangle rectangle;
    static Circle circle;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < tests; t++) {
            String firstLine = sc.nextLine();
            String secondLine = sc.nextLine();
            createShapes(firstLine, secondLine);
            if(rectangleIsInCircle(rectangle, circle)) {
                System.out.println("Rectangle inside circle");
                continue;
            }
            if (rectangleContainsCircle(rectangle, circle)) {
                System.out.println("Circle inside rectangle");
                continue;
            }
            if(onePointIsOut(rectangle, circle) && onePointIsIn(rectangle, circle) || onePointIsOnCircle(rectangle, circle)) {
                System.out.println("Rectangle and circle cross");
                continue;
            }
            if (t == tests - 1 && t != 0) {
//            if (doNotIntersect(rectangle, circle)) {
                System.out.println("Rectangle and circle do not cross");
                continue;
            }
            if(circleIntersectsRectangle(rectangle, circle)) {
                System.out.println("Rectangle and circle cross");
                continue;
            }
        }
    }

    private static boolean circleIntersectsRectangle(Rectangle r, Circle c) {
        return c.oY - c.radius <= r.aY && c.oX + c.radius >= r.aX ||
                c.oY + c.radius >= r.bY && c.oX + c.radius >= r.aX ||
                c.oY - c.radius <= r.aY && c.oX - c.radius <= r.bX ||
                c.oY + c.radius >= r.bY && c.oX - c.radius <= r.bX;
    }

    private static boolean onePointIsIn(Rectangle rectangle, Circle circle) {
        return circle.containsPoint(rectangle.bUp) ||
                circle.containsPoint(rectangle.b) ||
                circle.containsPoint(rectangle.a) ||
                circle.containsPoint(rectangle.downA);
    }

    private static boolean onePointIsOut(Rectangle rectangle, Circle circle) {
        return circle.doesntContainPoint(rectangle.bUp) ||
                circle.doesntContainPoint(rectangle.b) ||
                circle.doesntContainPoint(rectangle.a) ||
                circle.doesntContainPoint(rectangle.downA);
    }

    private static boolean rectangleContainsCircle(Rectangle r, Circle c) {
        return c.oX - c.radius >= r.aX &&
                c.oX + c.radius <= r.bX &&
                c.oY - c.radius >= r.bY &&
                c.oY + c.radius <= r.aY;
    }

    private static boolean doNotIntersect(Rectangle rectangle, Circle circle) {
        if (!circle.doesntContainPoint(rectangle.a)) {
            return false;
        }
        if (!circle.doesntContainPoint(rectangle.downA)) {
            return false;
        }
        if (!circle.doesntContainPoint(rectangle.b)) {
            return false;
        }
        return circle.doesntContainPoint(rectangle.bUp);
    }

    private static boolean onePointIsOnCircle(Rectangle rectangle, Circle circle) {
        if (circle.intersectsPoint(rectangle.a)) {
            return true;
        }
        if (circle.intersectsPoint(rectangle.downA)) {
            return true;
        }
        if (circle.intersectsPoint(rectangle.b)) {
            return true;
        }
        return circle.intersectsPoint(rectangle.bUp);
    }

    private static boolean rectangleIsInCircle(Rectangle rectangle, Circle circle) {
        if (!circle.containsPoint(rectangle.a)) {
            return false;
        }
        if (!circle.containsPoint(rectangle.downA)) {
            return false;
        }
        if (!circle.containsPoint(rectangle.b)) {
            return false;
        }
        return circle.containsPoint(rectangle.bUp);
    }

    private static void createShapes(String firstLine, String secondLine) {
        String[] firstArgs = firstLine.split("[^0-9-.]+");
        String[] secondArgs = secondLine.split("[^0-9-.]+");
        if (firstLine.charAt(0) == 'c') {
            double oX = Double.parseDouble(firstArgs[1]);
            double oY = Double.parseDouble(firstArgs[2]);
            double r = Double.parseDouble(firstArgs[3]);
            circle = new Circle(oX, oY, r);

            double aX = Double.parseDouble(secondArgs[1]);
            double aY = Double.parseDouble(secondArgs[2]);
            double bX = Double.parseDouble(secondArgs[3]);
            double bY = Double.parseDouble(secondArgs[4]);
            rectangle = new Rectangle(aX, aY, bX, bY);
        } else {
            double aX = Double.parseDouble(firstArgs[1]);
            double aY = Double.parseDouble(firstArgs[2]);
            double bX = Double.parseDouble(firstArgs[3]);
            double bY = Double.parseDouble(firstArgs[4]);
            rectangle = new Rectangle(aX, aY, bX, bY);

            double oX = Double.parseDouble(secondArgs[1]);
            double oY = Double.parseDouble(secondArgs[2]);
            double r = Double.parseDouble(secondArgs[3]);
            circle = new Circle(oX, oY, r);
        }
    }
}

class Rectangle {
    public double aX;
    public double aY;
    public double bX;
    public double bY;
    public Point a;
    public Point downA;
    public Point b;
    public Point bUp;

    public Rectangle(double aX, double aY, double bX, double bY) {
        this.aX = aX;
        this.aY = aY;
        this.bX = bX;
        this.bY = bY;
        a = new Point(this.aX, this.aY);
        downA = new Point(this.aX, this.bY);
        b = new Point(this.bX, this.bY);
        bUp = new Point(this.bX, this.aY);
    }

//    public double width() {
//        double width = this.bX - this.aX;
//        return width;
//    }
//
//    public double height() {
//        double height = this.aY - this.bY;
//        return height;
//    }
}

class Circle {
    public double oX;
    public double oY;
    public double radius;

    public Circle(double oX, double oY, double radius) {
        this.oX = oX;
        this.oY = oY;
        this.radius = radius;
    }

    public boolean containsPoint(Point p) {
        double dSquare = Math.pow((p.x - this.oX), 2d) + Math.pow((p.y - this.oY), 2d);
        double rSquare = Math.pow(this.radius, 2);
        return dSquare < rSquare;
    }

    public boolean doesntContainPoint(Point p) {
        double dSquare = Math.pow((p.x - this.oX), 2d) + Math.pow((p.y - this.oY), 2d);
        double rSquare = Math.pow(this.radius, 2);
        return dSquare > rSquare;
    }

    public boolean intersectsPoint(Point p) {
        double dSquare = Math.pow((p.x - this.oX), 2d) + Math.pow((p.y - this.oY), 2d);
        double rSquare = Math.pow(this.radius, 2);
        return dSquare == rSquare;
    }
}

class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
