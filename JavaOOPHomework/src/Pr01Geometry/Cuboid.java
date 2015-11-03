package Pr01Geometry;

import java.util.ArrayList;

public class Cuboid extends SpaceShape{

    private double width;
    private double height;
    private double depth;

    public Cuboid(Vertex3D point, double width, double height, double depth) {
        super(new ArrayList<Vertex3D>() {{
            add(point);
        }});
        setWidth(width);
        setHeight(height);
        setDepth(depth);
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

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    @Override
    public double getArea() {
        double area = 2.0d * (depth * height + height * width + width * depth);
        return area;
    }

    @Override
    public double getVolume() {
        double volume = width * height * depth;
        return volume;
    }

    @Override
    public String toString() {
        Vertex3D pointO = this.getVertices().get(0);
        double x = pointO.getX();
        double y = pointO.getY();
        double z = pointO.getZ();
        String text = "Cuboid with O(%.2f, %.2f, %.2f), width = %.2f, height = %.2f, depth = %.2f, area = %.2f, volume = %.2f";
        String info = String.format(text, x, y, z, width, height, depth, getArea(), getVolume());
        return info;
    }
}
