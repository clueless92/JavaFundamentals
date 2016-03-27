package JavaStreamsHomework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Pr01SumLines {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("res\\lines.txt"));
            String line = br.readLine();
            while (line != null) {
                int lineSum = 0;
                for (int i = 0; i < line.length(); i++) {
                    lineSum += line.charAt(i);
                }
                System.out.println(lineSum);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
