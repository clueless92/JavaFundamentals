package BashSoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class InputReader {
    private static final String END_COMMAND = "quit";

    static void readCommands() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            OutputWriter.writeMessage(String.format("%s > ", SessionData.currentPath));
            String input = reader.readLine().trim();
            if (input.equals(END_COMMAND)) {
                break;
            }
            CommandInterpreter.interpredCommand(input);
        }

        Thread[] threads = new Thread[Thread.activeCount()];
        Thread.enumerate(threads);
        for (Thread thread : threads) {
            try {
                if (!thread.getName().equals("main")) {
                    thread.join();
                }
            } catch (InterruptedException e) {
                OutputWriter.displayException(e.getMessage());
            }
        }
    }
}

