package JavaStreamsHomework;

import java.io.Serializable;

public class Course implements Serializable {

    private String name;
    private int numberOfStudents;

    public Course (String name, int numberOfStudents) {
        this.name = name;
        this.numberOfStudents = numberOfStudents;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
    }

    public void setNumberOfStudents (int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public int getNumberOfStudents () {
        return this.numberOfStudents;
    }
}
