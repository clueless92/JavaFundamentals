package JavaStreamsHomework;

import java.io.*;

public class Pr02AllCapitals {
    public static void main(String[] args){
        StringBuilder capitalText = new StringBuilder();
        BufferedReader bReader = null;
        try {
            bReader = new BufferedReader(new FileReader("res\\lines.txt"));
            String line = bReader.readLine();
            while (line != null) {
                capitalText.append(line);
                capitalText.append("\r\n");
                line = bReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bReader != null) {
                    bReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        PrintWriter pWriter = null;
        try {
            pWriter = new PrintWriter(new FileWriter("res\\lines.txt"));
            pWriter.print(capitalText.toString().toUpperCase());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pWriter != null) {
                pWriter.close();
            }
        }
    }
}
