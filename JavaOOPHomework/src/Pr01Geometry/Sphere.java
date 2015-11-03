package Pr01Geometry;

import java.util.ArrayList;

public class Sphere extends SpaceShape {

    private double radius;

    public Sphere(Vertex3D pointO, double radius) {
        super(new ArrayList<Vertex3D>() {{
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
        double area = 4 * Math.PI * Math.pow(radius, 2.0d);
        return area;
    }

    @Override
    public double getVolume() {
        double volume = (4.0d / 3.0d) * Math.PI * Math.pow(radius, 3.0d);
        return volume;
    }

    @Override
    public String toString() {
        Vertex3D pointO = this.getVertices().get(0);
        double x = pointO.getX();
        double y = pointO.getY();
        double z = pointO.getZ();
        String info = String.format("Sphere with O(%.2f, %.2f, %.2f), radius = %.2f area = %.2f, volume = %.2f",
                x, y, z, radius, getArea(), getVolume());
        return info;
    }
}
