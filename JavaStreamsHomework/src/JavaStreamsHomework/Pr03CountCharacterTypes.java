package JavaStreamsHomework;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Pr03CountCharacterTypes {
    public static void main(String[] args) {
        PrintWriter pWriter = null;
        BufferedReader bReader = null;
        List<Character> vowelsList = new ArrayList<Character>() {{
            add('a');
            add('e');
            add('o');
            add('i');
            add('u');
        }};
        List<Character> punctuationsList = new ArrayList<Character>() {{
            add('?');
            add('!');
            add('.');
            add(',');
        }};
        try {
            pWriter = new PrintWriter(new FileWriter("res\\count-chars.txt"));
            bReader = new BufferedReader(new FileReader("res\\words.txt"));
            int vowelsCount = 0;
            int consonantsCount = 0;
            int punctuationCount = 0;
            String line = bReader.readLine();
            StringBuilder text = new StringBuilder();
            while (line != null) {
                text.append(line);
                line = bReader.readLine();
            }
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (vowelsList.contains(c)) {
                    vowelsCount++;
                } else if (punctuationsList.contains(c)) {
                    punctuationCount++;
                } else if (c != ' ') {
                    consonantsCount++;
                }
            }
            pWriter.printf("Vowels: %d\r\nConsonants: %d\r\nPuntuation: %d", vowelsCount, consonantsCount, punctuationCount);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bReader != null) {
                    bReader.close();
                }
                if (pWriter != null) {
                    pWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
