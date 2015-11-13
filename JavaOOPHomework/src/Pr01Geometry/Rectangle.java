package Pr01Geometry;

import java.util.ArrayList;

public class Rectangle extends PlaneShape {

    private double width;
    private double height;

    public Rectangle(Vertex2D point, double width, double height) {
        super(new ArrayList<Vertex2D>() {{
            add(point);
        }});
        setWidth(width);
        setHeight(height);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        double area = width * height;
        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter = 2.0d * width + 2.0d * height;
        return perimeter;
    }

    @Override
    public String toString() {
        String superInfo = super.toString();
        String text = "%s, width = %.2f, height = %.2f, area = %.2f, perimeter = %.2f";
        String info = String.format(text, superInfo, width, height, this.getArea(), this.getPerimeter());
        return info;
    }
}
