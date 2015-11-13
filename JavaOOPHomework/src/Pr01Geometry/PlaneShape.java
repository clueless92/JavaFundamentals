package Pr01Geometry;

import java.util.List;

public abstract class PlaneShape extends Shape<Vertex2D> implements PerimeterMeasurable, AreaMeasurable {

    public PlaneShape(List<Vertex2D> vertices) {
        super(vertices);
    }

    @Override
    public String toString() {
        Vertex2D pointO = this.getVertices().get(0);
        double x = pointO.getX();
        double y = pointO.getY();
        String type = getClass().toString().substring(19);
        String info = String.format("%s with A(%.2f, %.2f)", type, x, y);
        return info;
    }
}
