package Pr01Geometry;

import java.util.List;

public abstract class SpaceShape extends Shape<Vertex3D> implements AreaMeasurable, VolumeMeasurable {

    public SpaceShape(List<Vertex3D> vertices) {
        super(vertices);
    }
}
