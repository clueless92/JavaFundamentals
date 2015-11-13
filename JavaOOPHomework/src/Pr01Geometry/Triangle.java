package Pr01Geometry;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends PlaneShape {

    public Triangle(Vertex2D pointA, Vertex2D pointB, Vertex2D pointC) {
        super(new ArrayList<Vertex2D>() {{
            add(pointA);
            add(pointB);
            add(pointC);
        }});
    }

    private double getSide(Vertex2D a, Vertex2D b) {
        double aB = Math.pow(a.getX() - b.getX(), 2.0d) + Math.pow(a.getY() - b.getY(), 2.0d);
        return Math.sqrt(aB);
    }

    @Override
    public double getArea() {
        List<Vertex2D> trianglePoints = super.getVertices();
        Vertex2D a = trianglePoints.get(0);
        Vertex2D b = trianglePoints.get(1);
        Vertex2D c = trianglePoints.get(2);
        double aB = getSide(a, b);
        double bC = getSide(b, c);
        double cA = getSide(c, a);
        double perHalf = (aB + bC + cA) / 2.0d;
        double area = Math.sqrt(perHalf * (perHalf - aB) * (perHalf - bC) * (perHalf - cA));
        return area;
    }

    @Override
    public double getPerimeter() {
        List<Vertex2D> trianglePoints = getVertices();
        Vertex2D a = trianglePoints.get(0);
        Vertex2D b = trianglePoints.get(1);
        Vertex2D c = trianglePoints.get(2);
        double aB = getSide(a, b);
        double bC = getSide(b, c);
        double cA = getSide(c, a);
        return aB + bC + cA;
    }

    @Override
    public String toString() {
        String superInfo = super.toString();
        List<Vertex2D> trianglePoints = getVertices();
        Vertex2D b = trianglePoints.get(1);
        Vertex2D c = trianglePoints.get(2);
        double bX = b.getX();
        double bY = b.getY();
        double cX = c.getX();
        double cY = c.getY();
        String text = "%s, B(%.2f, %.2f), C(%.2f, %.2f), area = %.2f, perimeter = %.2f";
        String info = String.format(text, superInfo, bX, bY, cX, cY, getArea(), getPerimeter());
        return info;
    }
}
