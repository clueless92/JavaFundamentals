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
        String superInfo = super.toString();
        String text = "%s, radius = %.2f, area = %.2f, parimeter = %.2f";
        String info = String.format(text, superInfo, radius, getArea(), getPerimeter());
        return info;
    }
}
