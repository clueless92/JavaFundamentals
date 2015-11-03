package Pr01Geometry;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main_Pr01Geometry {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[6];

        Shape sphere = new Sphere(new Vertex3D(4.0d, 2.1d, 3.9d), 5.5d);
        Shape pyramid = new SquarePyramid(new Vertex3D(4.4d, 3.2d, 5.0d), 5.0d, 4.5d);
        Shape cuboid = new Cuboid(new Vertex3D(1.9d, 2.5d, 9.0d), 5.4d, 6.0d, 10.1d);
        Shape triangle = new Triangle(new Vertex2D(1.9d, 2.5d), new Vertex2D(2.9d, 5.5d), new Vertex2D(4.3d, 7.7d));
        Shape circle = new Circle(new Vertex2D(0.5d, 10.0d), 5.6d);
        Shape rectangle = new Rectangle(new Vertex2D(0.5d, 10.0d), 1.1d, 2.2d);

        shapes[0] = sphere;
        shapes[1] = pyramid;
        shapes[2] = cuboid;
        shapes[3] = triangle;
        shapes[4] = circle;
        shapes[5] = rectangle;

        for (Shape shape : shapes) {
            System.out.println(shape);
        }
        System.out.println();

        List<Shape> largeVolumeShapes = Arrays.asList(shapes)
                .stream()
                .filter(s -> s instanceof VolumeMeasurable)
                .filter(v -> ((VolumeMeasurable) v)
                        .getVolume() > 40)
                .collect(Collectors.toList());

        for (Shape shape : largeVolumeShapes) {
            System.out.println(shape);
        }
        System.out.println();

        Comparator<Shape> byPerimeter = (s1, s2) -> {
            PerimeterMeasurable Shape1 = (PerimeterMeasurable) s1;
            PerimeterMeasurable Shape2 = (PerimeterMeasurable) s2;
            double perimeterShape1 = Shape1.getPerimeter();
            double perimeterShape2 = Shape2.getPerimeter();
            return perimeterShape1 < perimeterShape2 ? -1 :
                    perimeterShape1 > perimeterShape2 ? 1 : 0;
        };

        List<Shape> planeShapesByPerimeter = Arrays.asList(shapes)
                .stream()
                .filter(p -> p instanceof PlaneShape)
                .sorted(byPerimeter)
                .collect(Collectors.toList());

        for (Shape shape : planeShapesByPerimeter) {
            System.out.println(shape);
        }
    }
}
