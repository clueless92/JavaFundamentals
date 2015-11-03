package Pr01Geometry;

import java.util.List;

public abstract class PlaneShape extends Shape<Vertex2D> implements PerimeterMeasurable, AreaMeasurable {

    public PlaneShape(List<Vertex2D> vertices) {
        super(vertices);
    }
}
