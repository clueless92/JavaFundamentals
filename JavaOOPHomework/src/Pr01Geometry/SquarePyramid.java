package Pr01Geometry;

import java.util.ArrayList;

public class SquarePyramid extends SpaceShape {

    private double baseWidth;
    private double height;

    public SquarePyramid(Vertex3D baseCenter, double baseWidth, double height) {
        super(new ArrayList<Vertex3D>() {{
            add(baseCenter);
        }});
        setBaseWidth(baseWidth);
        setHeight(height);
    }

    public double getBaseWidth() {
        return baseWidth;
    }

    public void setBaseWidth(double baseWidth) {
        this.baseWidth = baseWidth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        double aSquare = Math.pow(baseWidth, 2.0d);
        double hSquare = Math.pow(height, 2.0d);
        double area = aSquare + 2 * baseWidth * Math.sqrt(aSquare / 4.0d + hSquare);
        return area;
    }

    @Override
    public double getVolume() {
        double volume = Math.pow(baseWidth, 2.0d) * height / 3.0d;
        return volume;
    }

    @Override
    public String toString() {
        Vertex3D pointO = this.getVertices().get(0);
        double x = pointO.getX();
        double y = pointO.getY();
        double z = pointO.getZ();
        String text = "Square pyramid with O(%.2f, %.2f, %.2f), base width = %.2f, height = %.2f, area = %.2f, volume = %.2f";
        String info = String.format(text, x, y, z, baseWidth, height, this.getArea(), this.getVolume());
        return info;
    }
}
