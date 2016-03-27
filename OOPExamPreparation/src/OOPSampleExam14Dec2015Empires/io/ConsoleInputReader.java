package OOPSampleExam14Dec2015Empires.io;

import java.util.Scanner;
import OOPSampleExam14Dec2015Empires.contracts.InputReader;

public class ConsoleInputReader implements InputReader {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String readLine() {
        String line = scanner.nextLine();

        return line;
    }
}