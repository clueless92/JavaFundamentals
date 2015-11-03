package Pr01Geometry;

import java.util.List;

public abstract class Shape<TVertexD extends Vertex2D> {

    protected List<TVertexD> vertices;

    public Shape(List<TVertexD> vertices) {
        setVertices(vertices);
    }

    public List<TVertexD> getVertices() {
        return vertices;
    }

    public void setVertices(List<TVertexD> vertices) {
        this.vertices = vertices;
    }

    @Override
    public abstract String toString();
}
