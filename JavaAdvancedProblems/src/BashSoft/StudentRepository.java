package BashSoft;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.util.regex.*;

public class StudentRepository {
    public static boolean isDataInitiated = false;
    public static LinkedHashMap<String, LinkedHashMap<String, ArrayList<Integer>>> studentsByCourse;

    public static void initializeData(String fileName) {
        if (isDataInitiated) {
            System.out.println(ExceptionMessages.DATA_ALREADY_INITIALIZED);
            return;
        }

        studentsByCourse = new LinkedHashMap<>();
        try {
            readData(fileName);
        } catch (IOException e) {
            OutputWriter.displayException(e.getMessage());
        }
        isDataInitiated = true;
    }

    private static void readData(String fileName) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "([A-Z][a-zA-Z#+]*_[A-Z][a-z]{2}_\\d{4})\\s+([A-Z][a-z]{0,3}\\d{2}_\\d{2,4})\\s+(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        String path = SessionData.currentPath + '\\' + fileName;
        List<String> lines = Files.readAllLines(Paths.get(path));

        for (String line : lines) {
//            String[] parts = line.split("\\s+");
            matcher = pattern.matcher(line);
//        }
//        while (true) {
//            String input = reader.readLine();
//            if (input.equals("")) {
//                break;
//            }
//            String[] parts = input.split("\\s+");
            if (!line.isEmpty() && matcher.find()) {
                String course = matcher.group(1);
                String student = matcher.group(2);
                Integer mark = Integer.parseInt(matcher.group(3));
                if (mark >= 0 && mark <= 100) {
                    if (!studentsByCourse.containsKey(course)) {
                        studentsByCourse.put(course, new LinkedHashMap<>());
                    }
                    if (!studentsByCourse.get(course).containsKey(student)) {
                        studentsByCourse.get(course).put(student, new ArrayList<>());
                    }
                    studentsByCourse.get(course).get(student).add(mark);
                }
            }
        }

        OutputWriter.writeMessageOnNewLine(ExceptionMessages.DATA_READ);
    }

    private static boolean isQueryForCoursePossible(String courseName) {
        if (!isDataInitiated) {
            OutputWriter.displayException(ExceptionMessages.DATA_NOT_INITIALIZED);
            return false;
        }

        if (!studentsByCourse.containsKey(courseName)) {
            OutputWriter.displayException(ExceptionMessages.NON_EXISTING_COURSE);
            return false;
        }

        return true;
    }

    private static boolean isQueryForStudentPossible(String courseName, String studentName) {
        if (!isQueryForCoursePossible(courseName)) {
            return false;
        }

        if (!studentsByCourse.get(courseName).containsKey(studentName)) {
            OutputWriter.displayException(ExceptionMessages.NON_EXISTING_STUDENT);
            return false;
        }

        return true;
    }

    public static void getStudentMarksInCourse(String course, String student) {
        if (!isQueryForStudentPossible(course, student)) {
            return;
        }

        ArrayList<Integer> marks = studentsByCourse.get(course).get(student);
        OutputWriter.printStudent(student, marks);
    }

    public static void getStudentsByCourse(String course) {
        if(!isQueryForCoursePossible(course)) {
            return;
        }

        OutputWriter.writeMessageOnNewLine(course + ":");
        for (Map.Entry<String, ArrayList<Integer>> student :
                studentsByCourse.get(course).entrySet()) {
            OutputWriter.printStudent(student.getKey(), student.getValue());
        }
    }
}
