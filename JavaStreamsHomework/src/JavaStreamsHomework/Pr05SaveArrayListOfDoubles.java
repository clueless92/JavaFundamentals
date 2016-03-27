package JavaStreamsHomework;

import java.io.*;
import java.util.ArrayList;

public class Pr05SaveArrayListOfDoubles {
    public static void main(String[] args) {
        ArrayList<Double> doublesList = new ArrayList<Double>() {{
            add(5.5); add(3d); add(34.43);
        }};
        save(doublesList);
        load(doublesList);
    }

    private static void load(ArrayList<Double> doublesList) {
        ObjectInputStream input = null;
        try {
            input = new ObjectInputStream(new FileInputStream("res\\doubles.list"));
            int size = doublesList.size();
            doublesList.clear();
            for (int i = 0; i < size; i++) {
                doublesList.add(input.readDouble());
            }
            System.out.println(doublesList);
        } catch (IOException e) {
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
    }

    private static void save(ArrayList<Double> doublesList) {
        ObjectOutputStream output = null;
        try {
            output = new ObjectOutputStream(new FileOutputStream("res\\doubles.list"));
            for (int i = 0; i < doublesList.size(); i++) {
                output.writeDouble(doublesList.get(i));
            }
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
