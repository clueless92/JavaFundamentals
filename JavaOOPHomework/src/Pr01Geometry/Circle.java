package Pr01Geometry;

import java.util.ArrayList;

public class Circle extends PlaneShape {

    private double radius;

    public Circle(Vertex2D pointO, double radius) {
        super(new ArrayList<Vertex2D>() {{
            add(pointO);
        }});
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    @Override
    public double getArea() {
        double area = Math.PI * Math.pow(radius, 2.0d);
        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter = 2.0d * Math.PI * radius;
        return perimeter;
    }

    @Override
    public String toString() {
        Vertex2D pointO = this.getVertices().get(0);
        double x = pointO.getX();
        double y = pointO.getY();
        String info = String.format("Circle with O(%.2f, %.2f), radius = %.2f, area = %.2f, parimeter = %.2f",
                x, y, radius, getArea(), getPerimeter());
        return info;
    }
}
