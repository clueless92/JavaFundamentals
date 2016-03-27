package JavaStreamsHomework;

import java.io.*;

public class Pr06SaveCustomObjectInFile {
    public static void main(String[] args) {
        Course java = new Course("Java Fundamentals", 200);
        save(java);
        Course loadedCourse = load();
        System.out.println(loadedCourse.getName() + " " + loadedCourse.getNumberOfStudents());
    }

    private static Course load() {
        ObjectInputStream input = null;
        Course readCourse = null;
        try {
            input = new ObjectInputStream(new FileInputStream("res\\course.save"));
            readCourse = (Course) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return readCourse;
    }

    private static void save(Course course) {
        ObjectOutputStream output = null;
        try {
            output = new ObjectOutputStream(new FileOutputStream("res\\course.save"));
            output.writeObject(course);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
