package Pr01Geometry;

import java.util.List;

public abstract class SpaceShape extends Shape<Vertex3D> implements AreaMeasurable, VolumeMeasurable {

    public SpaceShape(List<Vertex3D> vertices) {
        super(vertices);
    }

    @Override
    public String toString() {
        Vertex3D pointO = this.getVertices().get(0);
        double x = pointO.getX();
        double y = pointO.getY();
        double z = pointO.getZ();
        String type = getClass().toString().substring(19);
        String info = String.format("%s with O(%.2f, %.2f, %.2f)", type, x, y, z);
        return info;
    }
}
