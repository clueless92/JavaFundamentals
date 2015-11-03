package Pr01Geometry;

public class Vertex3D extends Vertex2D {
    private double x;
    private double y;
    private double z;

    public Vertex3D(double x, double y, double z) {
        super(x, y);
        setZ(z);
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
